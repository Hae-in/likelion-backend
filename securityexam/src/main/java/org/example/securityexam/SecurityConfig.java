package org.example.securityexam;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

@Configuration
@EnableWebSecurity // security 활성화
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 1. 사용자가 아무것도 안 했을 때 스프링부트의 시큐리티는 아래와 같은 설정으로 동작된다.
        // return http
        //         .authorizeHttpRequests(auth -> auth
        //                 .anyRequest() // 모든 요청에대해서
        //                 .authenticated() // 인증을 요구
        //         )
        //         .formLogin(Customizer.withDefaults()) // form 로그인 사용 -> 주석처리하면 팝업창으로 로그인
        //         .httpBasic(Customizer.withDefaults())
        //         .csrf(Customizer.withDefaults())
        //         .build();

        return http
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers( "/hi", "hello", "/test/*", "/loginForm", "/fail").permitAll() // 지정된 페이지는 인증없이 요청 가능
                        .anyRequest().authenticated() // 나머지 모든 요청에 대해서는 인증 요구
                )
                // .formLogin(Customizer.withDefaults())
                .formLogin(formLogin -> formLogin
                        // .loginPage("/loginForm") // 시큐리티가 제공하는 로그인폼 페이지가 아닌 사용자가 원하는 페이지로 사용하도록 설정
                        .defaultSuccessUrl("/success") // 로그인 성공시 이동할 페이지
                        // 1. 로그인 폼에서 로그인 성공시 -> success로 이동
                        // 2. 요청한 페이지에서 로그인 성공시 -> 요청한 페이지로 이동
                        // alwaysUse: true로 설정하면 항상 success로 이동 .defaultSuccessUrl("/success", true)
                        .loginProcessingUrl("/login_proc") // html form-action 파라미터 변경
                        .usernameParameter("email") // username input-name 파라미터 변경
                        .passwordParameter("pw") // password input-name 파라미터 변경
                        // .failureForwardUrl("/fail") // 로그인 실패시 이동할 페이지
                        .successHandler((request, response, authentication) -> {
                            // 인증에 성공 했을 때 내가 하고 싶은 일을 직접 구현
                            System.out.println("로그인 성공!!" + authentication.getName());
                            response.sendRedirect("/info");
                        })
                        .failureHandler((request, response, authentication) -> {
                            // 인증에 실패 했을 때
                            System.out.println("로그인 실패" + authentication.getMessage());
                            response.sendRedirect("/fail");
                        })
                )
                .logout(logout -> logout
                        // .logoutUrl("/logout_user") // post 전용, get 방식이 허용하는 것을 위험하다고 판단
                        .logoutSuccessUrl("/")
                        .addLogoutHandler((request, response, authentication) -> {
                            // 로그아웃 성공 시
                            System.out.println("로그아웃!! 세션 및 쿠키 삭제");
                            request.getSession(false).invalidate(); // 세션 삭제
                        })
                        .deleteCookies("JSESSIONID") // 쿠키 삭제
                )
                .build();
    }
}
