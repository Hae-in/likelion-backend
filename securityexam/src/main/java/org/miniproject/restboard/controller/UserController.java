package org.miniproject.restboard.controller;

import lombok.RequiredArgsConstructor;
import org.miniproject.restboard.domain.User;
import org.miniproject.restboard.dto.UserDTO;
import org.miniproject.restboard.dto.UserResponseDTO;
import org.miniproject.restboard.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserDTO dto) {
        User user = userService.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDTO.from(user));
    }

    @DeleteMapping("/{id}")
    // @PreAuthorize("hasRole('ADMIN') or #id == principal.id")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id, @AuthenticationPrincipal User currentUser) {
        userService.deleteUser(id, currentUser);

        return ResponseEntity.noContent().build();
    }
}
