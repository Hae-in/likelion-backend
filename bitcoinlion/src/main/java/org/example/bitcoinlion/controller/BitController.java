package org.example.bitcoinlion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index() {
        return "Bitcoin Lion";
    }

    @GetMapping("/bit")
    public String bit() {
        return "hello Lion";
    }

    @GetMapping("/log-test")
    public String logTest() {
        log.info("INFO 로그입니다. 평소에도 잘 보여요.");
        log.debug("DEBUG 로그입니다. 평소에는 안보여요.");
        return "log test";
    }
}
/*
* 현재 로거 레벨 확인
curl http://localhost:8080/actuator/loggers/org.example.bitcoinlion

* 로거 레벨 변경(POST 요청)
curl -X POST http://localhost:8080/actuator/loggers/org.example.bitcoinlion \                                                                                        ─╯
        -H "Content-Type: application/json" \
        -d '{"configuredLevel": "DEBUG"}'

* 서버 재 시작하면 리셋됨
* 문제 해결되면 원상태로 복구하기: INFO
*/
