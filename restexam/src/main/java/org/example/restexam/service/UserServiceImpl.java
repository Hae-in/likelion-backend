package org.example.restexam.service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.User;
import org.example.restexam.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository; // 생성자 주입

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public User addUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("사용자 아이디는 필수입니다.");
        }

        User foundUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));

        // 수정할 값을 매개변수로 전달 받았을 것이므로...
        // 회원정보 수정 페이지: 이름, 비밀번호, 주소, 전화번호, 등록일 ...
        // 비밀번호, 주소를 변경하고 싶을때? 어떤 값을 전달해야할까??
        if (user.getName() != null) // null로 넘어왔다 라고 한다면 그 값을 수정할 의도가 없다는 것. 그래서 null이 아닐때만 처리
            foundUser.setName(user.getName());   // 무슨의미인지 이해되시죠??
        if (user.getEmail() != null)
            foundUser.setEmail(user.getEmail());

        return foundUser;    // 오류없이 여기까지 수행되면, commit 이 일어남.
        // jpa 는 커밋되는 시점에 변경을 감지해서 업데이트를 진행해줄것임..

        // save() 를 호출 할 필요 없음!!   이렇게 처리하는 것보다 변경을 감지해서 처리하는것이 좋음.
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found.");
        }
        userRepository.deleteById(id);
    }
}
