package org.miniproject.restboard.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.miniproject.restboard.domain.Role;
import org.miniproject.restboard.domain.User;
import org.miniproject.restboard.dto.UserDTO;
import org.miniproject.restboard.exception.DuplicateLoginIdException;
import org.miniproject.restboard.repository.RoleRepository;
import org.miniproject.restboard.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(UserDTO dto) {
        // loginId 중복 체크
        if(userRepository.existsByLoginId(dto.getLoginId())) {
            throw new DuplicateLoginIdException("이미 존재하는 로그인 ID입니다.");
        }

        // User 객체 생성
        User user = new User();
        user.setLoginId(dto.getLoginId());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(roleRepository.findByName("USER"));

        // 저장 후 반환
        return userRepository.save(user);
    }

    public void deleteUser(Long id, User currentUser) {
        // 존재 여부 확인
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User with id " + id + " does not exist");
        }

        // 권한 확인
        boolean isAdmin = currentUser.getRole().getName().equals("ADMIN");
        boolean isOwner = currentUser.getId().equals(id);

        if(!isAdmin && !isOwner) {
            throw new AccessDeniedException("You are not allowed to perform this action");
        }

        // 삭제
        userRepository.deleteById(id);
    }
}
