package org.example.springdatajpa3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 사용자 추가
    public User findByUserId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + "에 해당하는 고객을 찾을 수 없습니다."));
    }

    // 사용자 조회
    // 사용자 수정
    // 사용자 삭제
}
