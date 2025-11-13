package org.example.jwtexam.jwt.exception;

import lombok.Getter;

import java.util.Arrays;

public enum JwtExceptionCode {
    UNKNOWN_ERROR("UNNOWN_ERROR", "알수없어요."),
    NOT_FOUND_TOKEN("NOT_FOUND_TOKEN", "Header에서 토큰의 값을 찾지 못했어요."),
    INVALID_TOKEN("INVALID_TOKEN", "유효하지 않은 토큰이에요."),
    EXPIRED_TOKEN("EXPIRED_TOKEN", "기간이 만료된 토큰이에요."),
    UNSUPPORTED_TOKEN("UNSUPPORTED_TOKEN", "지원하지 않는 토큰이에요.");

    JwtExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    private String code;
    @Getter
    private String message;

    // 코드를 기반으로 Enum 상수를 찾는 정적 메서드
    public static JwtExceptionCode findByCode(String code) {
        return Arrays.stream(JwtExceptionCode.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElse(UNKNOWN_ERROR);
    }
}
