package org.example.jwtexam.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CustomUserDetailsTest {

    @Test
    @DisplayName("사용자 권한 정보가 ROLE_ 와 함께 잘 생성되는지 테스트")
    void getAuthorities() {
        // given
        List<String> roles = List.of("USER", "ADMIN");
        CustomUserDetails userDetails = new CustomUserDetails(
                "goldbb",
                "1234",
                "김금삐",
                roles
        );

        // when
        List<String> authotiries = userDetails.getAuthorities()
                .stream()
                .map(auth -> auth.getAuthority())
                .collect(Collectors.toList());

        // then
        assertEquals(2, authotiries.size());
        assertTrue(authotiries.contains("ROLE_USER"));
        assertTrue(authotiries.contains("ROLE_ADMIN"));
    }

    @Test
    void getPassword() {
    }

    @Test
    void getUsername() {
    }

    @Test
    void isAccountNonExpired() {
    }

    @Test
    void isAccountNonLocked() {
    }

    @Test
    void isCredentialsNonExpired() {
    }

    @Test
    void isEnabled() {
    }

    @Test
    void getName() {
    }
}