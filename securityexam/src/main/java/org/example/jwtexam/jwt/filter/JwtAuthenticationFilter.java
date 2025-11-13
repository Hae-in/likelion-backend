package org.example.jwtexam.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // 필터? 요청에 포함된 JWT(AccessToken)을 검증
    // 토큰이 유효(인증된 사용자)하다면?
    // Spring Security의 SecurityContextHolder에다가 사용자 인증 정보 (Authentication)를 등록.

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}
