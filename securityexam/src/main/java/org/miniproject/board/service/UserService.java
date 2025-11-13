package org.miniproject.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.miniproject.board.domain.Role;
import org.miniproject.board.domain.User;
import org.miniproject.board.dto.UserRegisterDTO;
import org.miniproject.board.repository.RoleRepository;
import org.miniproject.board.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder; // 비밀번호 인코딩

    // logigId 해당하는 사용자가 있는지 체크
    // DB에 존재하는지 확인
    public boolean existsByUsername(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    // 회원 가입
    public User registerUser(UserRegisterDTO registerDTO) {
        // DTO에서 가져온 값을 엔티티에 담기
        User user = new User();
        user.setLoginId(registerDTO.getLoginId());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));  // 패스워드는 반드시 인코딩해서 저장
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());

        // private List<String> roles;
        // Role의 name으로 Role의 객체를 찾아와서(findByName) 찾아온 Role의 객체를 Set<Role> roles에 담는다
        Set<Role> roles = new HashSet<>();

        // 디폴트로 USER 권한을 부여
        if (registerDTO.getRoles() == null || registerDTO.getRoles().isEmpty()) {
            Role userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("USER 권한을 찾을 수 없습니다. "));
            roles.add(userRole);
        }

        user.setRoles(roles);

        return userRepository.save(user);
    }

    // 회원 조회
    public User findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    // 회원 삭제
    public void deleteUser(Long id, String currentLoginId) {
        // 현재 로그인한 사용자 조회
        User currentUser = findByLoginId(currentLoginId);
        if (currentUser == null) {
            throw new RuntimeException("현재 로그인한 사용자를 찾을 수 없습니다.");
        }

        // 삭제할 사용자 조회
        User targetUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("삭제할 사용자를 찾을 수 없습니다."));

        // 삭제 권한 확인: 본인 계정 또는 ADMIN 역할만 삭제 가능
        boolean isAdmin = currentUser.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));
        boolean isOwner = targetUser.getLoginId().equals(currentUser.getLoginId());

        if (!isAdmin && !isOwner) {
            throw new SecurityException("삭제 권한이 없습니다.");
        }

        userRepository.delete(targetUser);
    }
}
