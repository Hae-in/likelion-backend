package org.example.securityexam4.service;

import lombok.RequiredArgsConstructor;
import org.example.securityexam4.domain.Role;
import org.example.securityexam4.domain.User;
import org.example.securityexam4.dto.UserRegisterDTO;
import org.example.securityexam4.repository.RoleRepository;
import org.example.securityexam4.repository.UserRepository;
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

    // username에 해당하는 사용자가 있는지 체크
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    // 회원가입
    public User registerUser(UserRegisterDTO registerDTO) {
        // DTO에서 가져온 값을 엔티티에 담기
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));  // 패스워드는 반드시 인코딩해서 저장
        user.setName(registerDTO.getName());
        user.setEmail(registerDTO.getEmail());

        // private List<String> roles;
        // Role의 name으로 Role의 객체를 찾아와서(findByName) 찾아온 Role의 객체를 Set<Role> roles에 담는다
        Set<Role> roles = new HashSet<>();

        // 컨트롤러에서 사용자가 권한을 하나도 선택하지 않았다면, 디폴트로 USER 권한을 부여하고,
        if (registerDTO.getRoles() == null || registerDTO.getRoles().isEmpty()) {
            Role userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("USER 권한을 찾을 수 없습니다. "));
            roles.add(userRole);
        } else {
            // 권한을 선택했다면, 선택한 권한들로 회원 가입 진행
            for (String roleName : registerDTO.getRoles()) {
                Role role = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException(roleName + " 권한을 찾을 수 없습니다."));
                roles.add(role);
            }
        }

        user.setRoles(roles);

        return userRepository.save(user);
    }
}
