package org.miniproject.board.security;

import lombok.RequiredArgsConstructor;
import org.miniproject.board.domain.Role;
import org.miniproject.board.domain.User;
import org.miniproject.board.repository.UserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 로그인처리 = security
// security: 얻은 loginId, password를 가지고 UserDetailsService 타입의 loadUserByUsername 호출
// security한테 UserDetails 타입의 사용자정보 보내줌
// 인증

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId);

        if (user == null) {
            throw new UsernameNotFoundException(loginId + " 에 해당하는 사용자가 없습니다.");
        }

        // 있으면
        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(loginId);
        userBuilder.password(user.getPassword());
        userBuilder.roles( // role이름을 String으로 들어가야함
                user.getRoles() // role들 얻을 수 있음
                        .stream()
                        .map(Role::getName) // role name만 꺼냄
                        .toList()
                        .toArray(new String[0])
        );

        return userBuilder.build();
    }
}
