package org.example.basicsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello() {
        log.info("----- UserController hello() 실행");
        return "Hello world";
    }

    @GetMapping("/api/hello")
    public String hello2() {
        log.info("----- /api/hello");
        return "Hello world 2";
    }
}
