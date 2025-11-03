package org.example.securityexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityexamApplication.class, args);

        // 클라이언트 - 요청 -> 서버
        // 클라이언트 <- 응답 - 서버

        // 요청:
        // 1. 서블릿
        // 2. 필터
        // 3. 리스터(이벤트성 - 세션이 생성될 때, 리퀘스트에 값이 추가 될 때)
    }

}
