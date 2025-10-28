package org.example.restexam.controller;

import org.example.restexam.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    // 전체 리스트 조화
    @GetMapping("/users")
    public List<User> getUsers() {
        return null;
    }

    // 특정 사용자 조회
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return null;
    }

    // 사용자 생성
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return null;
    }

    // 사용자 수정
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user) {
        return null;
    }

    // 사용자 삭제
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {

    }
}
