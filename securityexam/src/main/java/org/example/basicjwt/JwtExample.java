package org.example.basicjwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtExample {
    public static void main(String[] args) {
        // 1. 시크릿 키 (256비트)
        // 방법 1: 랜덤 키 생성 (실행할 때마다 다른 키 생성)
        SecretKey randomKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println("randomKey" + randomKey);

        // 방법 2: 문자열로부터 키 생성 (같은 문자열이면 항상 같은 키 생성)
        String secret = "abcdefghijklmnopqrstuvwxzy123456"; // 나만 아는 문자열로!!
        SecretKey signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        System.out.println("signingKey: " + signingKey);

        //SecretKey는 jwt 토큰을 생성할 때 사용(서명을 추가할 때)

        // 2. jwt 생성
        String jwt = Jwts.builder()
                .issuer("lion-auth") //토큰을 발급한 주체
                .subject("goldbb") //username  토큰의 주인. 사용자ID or email
                .audience().add("lion-server").add("lion-frontserver").and()  // 이 토큰은 누구를 위한 것인가를 명시해서 의도하지 않은 곳에서 사용을 방지
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //토큰만료시간  3600초 = 60분 = 1시간
                .notBefore(new Date()) //토큰이 유효해지는 시간설정. 이 시간 전에는 토큰을 사용할 수 없음. 지금부터
                .claim("role", "ADMIN") // 커스텀 데이터, 표준 클레임외에 필요한 정보를 넣을 수 있다.
                .claim("name", "김금삐")
                .signWith(signingKey) //토큰에 서명추가
                .compact(); //jwt 문자열로 변환

        System.out.println("jwt: " + jwt);

        // https://www.jwt.io/

        //3. JWT 파싱 및 검증
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(signingKey)
                    .requireIssuer("lion-auth")
                    .requireAudience("lion-server")
                    .build() // 파싱
                    .parseSignedClaims(jwt)
                    .getPayload();

            // 클레임 정보 출력
            System.out.println("=== JWT 검증 성공 ===");
            System.out.println("발급자: " + claims.getIssuer());
            System.out.println("사용자 ID: " + claims.getSubject());
            System.out.println("대상: " + claims.getAudience());
            System.out.println("발급 시간: " + claims.getIssuedAt());
            System.out.println("만료 시간: " + claims.getExpiration());
            System.out.println("역할: " + claims.get("role", String.class));
            System.out.println("이름: " + claims.get("name", String.class));
        } catch (IncorrectClaimException i) {
            System.out.println("클레임 값이 일치하지 않습니다.");
        } catch (JwtException j) {
            System.out.println("토큰 검증 실패!! " + j.getMessage());
        }
    }
}
