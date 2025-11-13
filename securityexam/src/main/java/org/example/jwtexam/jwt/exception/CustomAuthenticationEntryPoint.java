package org.example.jwtexam.jwt.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint { // 예외 발생 했을 때
    private final ObjectMapper objectMapper; // rest api 였을때 json으로 출력

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String exception = (String) request.getParameter("exception");

        // 1. request.getAttribute("exception"); 이 null 일 경우 어떻게 처리할까요?
        // spring security가 전달한 AuthenticationException 로그로 남긴다.
        if (exception == null) {
            log.error("CustomAuthenticationEntryPoint::commence Occured: " + authException.getMessage());
        }

        // 요청이 뷰를 요청하는 것인지 데이터를 요청하는 것인지에 따라서 다르게 처리 될 필요가 있다.
        // Restful로 요청한건지 그냥 페이지를 요청한거지에 따라 구분
        if (isRestRequest(request)) {
            // rest 요청이 들어왔을 때 처리
            handleRestResponse(exception, request, response);
        } else {
            // 페이지로 요청이 들어왔을 때 처리
            handlePageResponse(exception, request, response, authException);
        }
    }

    // 요청이 rest 인지 확인
    private boolean isRestRequest(HttpServletRequest request) {
        String requestWithHeader = request.getHeader("X-Requested-With");
        String uri = request.getRequestURI();

        boolean isApi = uri.startsWith("/api/") || uri.startsWith("/error");
        return "XMLHttpRequest".equals(requestWithHeader) || isApi;
    }

    // 페이지로 요청이 들어왔을때 인증되지 않은 사용자라면 특정 페이지로 리다이렉션 하게 구현
    private void handlePageResponse(String exception, HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error("Page Request - Commence : {}", exception);

        if (exception == null) {
            // 추가적으로 할일이 있다면 이쪽에 구현 ex) 예외처리 로직
            log.error("Page Request - Commence : {}", exception);
        } else {
            log.error("Page Request - Commence : {}", authException.getMessage());

        }

        response.sendRedirect("/loginform");
    }

    //
    private void handleRestResponse(String exception, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.error("Rest Request - Commence Occured : {}", exception);
        // jwt를 이용해서 인증할 때 발생할 수 있는 예외들 존재

        JwtExceptionCode code = JwtExceptionCode.findByCode(exception);

        // UNKNOWN_ERROR로 나왔다면, authException으로 에러를 남겨볼까요?
        if (code == JwtExceptionCode.UNKNOWN_ERROR && exception == null) {
            // 이런 경우에 해야할 일이 있다면 여기 구현
            log.error("Rest Request - authException 인증 예외 발생");
        }

        // 나머지 경우는 code 값에 따라서 응답으로 보내주면 됨
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // rest 컨트롤러니까 json 형태로 변환해서 보내야함: ObjectMapper
        HashMap<String, Object> errorInfo = new HashMap<>();
        errorInfo.put("message", code.getMessage());
        errorInfo.put("code", code.getCode());

        String responseJson = objectMapper.writeValueAsString(errorInfo);
        response.getWriter().print(responseJson);
    }
}
