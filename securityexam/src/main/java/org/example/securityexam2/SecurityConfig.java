package org.example.securityexam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest() // 모든 요청에대해서
                        .authenticated() // 인증을 요구
                )
                .formLogin(Customizer.withDefaults()) // form 로그인 사용 -> 주석처리하면 팝업창으로 로그인
                .httpBasic(Customizer.withDefaults())
                .csrf(Customizer.withDefaults())
                .logout(logout -> logout
                        .addLogoutHandler((request, response, authentication) -> {
                            System.out.println("로그아웃 완료...");
                        })
                )
                .rememberMe(rememberMe -> rememberMe
                        .rememberMeParameter("rememberMe")
                        .tokenValiditySeconds(60))
                .build();
    }
}
