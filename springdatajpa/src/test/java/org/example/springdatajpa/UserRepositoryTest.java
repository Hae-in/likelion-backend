package org.example.springdatajpa;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // 테스트가 끝난 후 롤백
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository; // UserRepository 주입

    @Test
    void 사용자_추가() {
        User user = new User("goldbb", "goldbb@gmail.com");
        User saveuser = userRepository.save(user);

        // assertThat(user.getId()).isNotNull();
        // assertThat(saveuser.getName()).isEqualTo("admin");
        System.out.println(saveuser);
    }

    @Test
    void 사용자_수정() {

        User user = new User("hong", "hong@gmail.com");
        User saveuser = userRepository.save(user);

        saveuser.setName("hhong");
        userRepository.save(user);

        User updateuser = userRepository.findById(saveuser.getId()).get();
        System.out.println(updateuser);

        assertThat(updateuser.getName()).isEqualTo("hhong");
    }

    @Test
    void 사용자_삭제() {
        User user = new User("test", "test@test.com");
        userRepository.save(user);

        User founduser = userRepository.findById(user.getId()).get();
        userRepository.delete(user);

        assertThat(userRepository.findById(user.getId())).isNull();
    }

    // TODO: 수정할것
    void 사용자_등록2() {}
}
