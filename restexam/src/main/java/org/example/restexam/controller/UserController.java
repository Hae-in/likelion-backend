package org.example.restexam.controller;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.User;
import org.example.restexam.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService; // 생성자 주입

    // 사용자 생성
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);

        // TODO: 응답을 좀 더 세심하게 수정하기
        return ResponseEntity.ok(createdUser);
    }

    // 전체 리스트 조화
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // 특정 사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        // TODO: id가 없을경우 어떻게 처리할것인가?

        return ResponseEntity.ok(userService.getUser(id));
    }

    // 사용자 수정
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        // user.setId(user.getId()); // 500번 오류 발생
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // 사용자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build(); // <Response body is empty> 출력되지만 삭제 정상 작동
    }
}
