package org.example.jwtexam.security;

import org.example.jwtexam.domain.Role;
import org.example.jwtexam.domain.User;
import org.example.jwtexam.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomUserDetailsServiceTest {

    @Test
    @DisplayName("존재하지 않는 사용자 아이디로 메서드를 실행했을 때 UserNotFoundException 발생")
    void loadUserByUsername_NotFound() {
        // given
        UserRepository userRepository = mock(UserRepository.class);
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService(userRepository);
        when(userRepository.findByUsername("noname")).thenReturn(Optional.empty());

        // when
        // CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername("hong");
        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername("hong"));
    }

    @Test
    void loadUserByUsername() {
        // given
        UserRepository userRepository = mock(UserRepository.class); // 가짜 객체를 넣어줌
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService(userRepository);

        User user = new User();
        user.setUsername("goldbb");
        user.setPassword("1234");
        user.setName("김금삐");

        Role roleUser = new Role();
        roleUser.setId(1L);
        roleUser.setName("USER");

        Role roleAdmin = new Role();
        roleAdmin.setId(2L);
        roleAdmin.setName("ADMIN");

        user.setRoles(Set.of(roleUser, roleAdmin));

        when(userRepository.findByUsername("goldbb")).thenReturn(Optional.of(user));

        // when
        CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername("goldbb");

        // then
        assertEquals("goldbb", userDetails.getUsername());
        assertEquals("1234", userDetails.getPassword());
        assertEquals("김금삐", userDetails.getName());
        assertTrue (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));

        verify(userRepository,times(1)).findByUsername("carami");
    }
}