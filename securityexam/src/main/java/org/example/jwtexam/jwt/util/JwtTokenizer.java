package org.example.jwtexam.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.jwtexam.jwt.exception.JwtExceptionCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtTokenizer {
    // JwtTokenizer에서 중요한 작업
    // 1. 토큰 생성
    // 2. 토큰 파싱

    private final byte[] accessSecret;
    private final byte[] refreshSecret;

    @Getter
    private final Long accessTokenExpireCount;
    @Getter
    private final Long refreshTokenExpireCount;

    /*
    jwt:
    secretKey:12345678901234567890123456789012
    refreshKey:abcdefghijklmnopqrstuvwxzy123456
    access-expiration-ms:1800000     #30*60*1000
    refresh-expiration-ms:604800000  # 7일
    */

    public JwtTokenizer(@Value("${jwt.secretKey}") String accessSecret,
                        @Value("${jwt.refreshKey}") String refreshSecret,
                        @Value("${jwt.access-expiration-ms}") String accessTokenExpireCount,
                        @Value("${jwt.refresh-expiration-ms}") String refreshTokenExpireCount) {
        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);
        this.accessTokenExpireCount = Long.parseLong(accessTokenExpireCount);
        this.refreshTokenExpireCount = Long.parseLong(refreshTokenExpireCount);
    }

    // 이 객체가 가지고 있으면 편하게 사용할 메서드
    // ACCESS TOKEN 생성
    public String createAccessToken(Long id,
                                    String email,
                                    String name,
                                    String username,
                                    List<String> roles) {
        return createToken(id, email, name, username, roles, accessTokenExpireCount, accessSecret);
    }

    // REFRESH TOKEN 생성
    public String createRefreshToken(Long id,
                                     String email,
                                     String name,
                                     String username,
                                     List<String> roles) {
        return createToken(id, email, name, username, roles, refreshTokenExpireCount, refreshSecret);
    }

    private String createToken(Long id,
                               String email,
                               String name,
                               String username,
                               List<String> roles,
                               Long expiration,
                               byte[] secret) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(username)
                .claim("email", email)
                .claim("userId", id)
                .claim("name", name)
                .claim("roles", roles)
                .issuedAt(now)
                .expiration(expirationDate)
                .signWith(getSigningKey(secret))
                .compact();
    }

    private SecretKey getSigningKey(byte[] secretKey) {
        return Keys.hmacShaKeyFor(secretKey);
        // return new SecretKeySpec(secretKey, "HmacSHA256");
    }

    // 토큰을 파싱하는 메서드
    private Claims parseToken(String token, byte[] secret) {
        return Jwts.parser()
                .verifyWith(getSigningKey(secret))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // AcessToken 파싱
    public Claims parseAccessToken(String token) {
        return parseToken(token, accessSecret);
    }

    // RefreshToken 파싱
    public Claims parseRefreshToken(String token) {
        return parseToken(token, refreshSecret);
    }

    // 토큰에서 id 값만 빠르게 꺼내고 싶다면?
    // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLqsJXqsr3rr7giLCJlbWFpbCI6ImNhcmFtaUBjYXJhbWkuY29tIiwidXNlcklkIjoxLCJuYW1lIjoiY2FyYW1pIiwicm9sZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJpYXQiOjE3NjI3NTYwMDEsImV4cCI6MTc2Mjc1NzgwMX0.gHoznGRXjFrOEToduhAYtGz7tz6v4NvKFB7UExo9vVg
    public Long getUserIdFromToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("잘못된 형식 입니다.");
        }

        try {
            // 인증 방식에 따라서 앞에 문자열을 포함해서 들어오는 경우가 있음
            String jwt = token.substring(7); // "Bearer " 제거
            Claims claims = parseToken(jwt, accessSecret);

            return claims.get("userId", Long.class);
        } catch (ExpiredJwtException e) {
            log.warn("만료된 Access 토큰입니다. {}", e.getMessage());
            throw new RuntimeException(JwtExceptionCode.EXPIRED_TOKEN.getMessage());
        } catch (SignatureException | MalformedKeyException e) {
            log.warn("유효하지 않은 토큰입니다. {}", e.getMessage());
            throw new RuntimeException(JwtExceptionCode.INVALID_TOKEN.getMessage());
        } catch (Exception e) {
            log.warn("JWT 파싱중 발생한 알수없는 오류입니다. {}", e.getMessage());
            throw new RuntimeException(JwtExceptionCode.UNKNOWN_ERROR.getMessage());
        }
    }
}
