package org.miniproject.restboard.security;

import lombok.RequiredArgsConstructor;
import org.miniproject.restboard.domain.Role;
import org.miniproject.restboard.domain.User;
import org.miniproject.restboard.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        org.springframework.security.core.userdetails.User.UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(loginId);
        userBuilder.password(user.getPassword());
        userBuilder.authorities(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));

        return userBuilder.build();
    }
}
