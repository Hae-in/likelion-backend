package org.example.springdatajpa3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            // id=1 조회
            // userRepository.findById(1L).ifPresent(System.out::println);

            // 커스텀 출력
            // userRepository.lionCustome();

            // 이름으로 검색
            // userRepository.findByUserName("Olivia Park").forEach(System.out::println);

            // 사용자가 입력한 값에 따라서 쿼리가 동적으로 생성
            // userRepository.findUserDynamically("Olivia Park", null).forEach(System.out::println); // 이름검색
            userRepository.findUserDynamically("Park", null).forEach(System.out::println); // 이름검색 like
            // userRepository.findUserDynamically(null, "olivia.park@example.com").forEach(System.out::println); // email 감색
            // userRepository.findUserDynamically("Olivia Park", "olivia.park@example.com").forEach(System.out::println); // 해당 사용자 검색
            // userRepository.findUserDynamically(null, null).forEach(System.out::println); // 전체검색
        };
    }
}
