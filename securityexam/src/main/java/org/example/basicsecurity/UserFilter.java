package org.example.basicsecurity;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
        System.out.println("----- UserFilter init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----- UserFilter doFilter() filterChain.doFilter 실행 전");
        filterChain.doFilter(servletRequest, servletResponse); // 원래 가려고했던 컨트롤러로 이동
        System.out.println("----- UserFilter doFilter() filterChain.doFilter 실행 후");

        // ----- UserFilter doFilter() filterChain.doFilter 실행 전
        // 2025-11-03T15:39:05.568+09:00  INFO 6925 --- [securityexam] [nio-8080-exec-1] o.example.basicsecurity.UserController   : ----- UserController hello() 실행
        // ----- UserFilter doFilter() filterChain.doFilter 실행 후
    }

    @Override
    public void destroy() {
        // Filter.super.destroy();
        System.out.println("----- UserFilter destroy()"); // WAS가 자동으로 실행
    }
}
