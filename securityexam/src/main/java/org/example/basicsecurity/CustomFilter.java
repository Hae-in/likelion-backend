package org.example.basicsecurity;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/api/*")
public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----- CustomeFilter filterChain.doFilter() 실행 전");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("----- CustomeFilter filterChain.doFilter() 실행 후");
    }
}
