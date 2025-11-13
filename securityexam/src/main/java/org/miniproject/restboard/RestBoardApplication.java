package org.miniproject.restboard;

import lombok.extern.slf4j.Slf4j;
import org.miniproject.restboard.domain.Role;
import org.miniproject.restboard.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class RestBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestBoardApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
        return args -> {
            // 데이터베이스에 Role 테이블에 데이터가 없으면 실행하지 않고,
            // 하나도 없으면 USER와 ADMIN 을 추가
            if (roleRepository.count() == 0) {
                Role userRole = new Role();
                userRole.setName("USER");

                Role adminRole = new Role();
                adminRole.setName("ADMIN");

                roleRepository.saveAll(List.of(userRole, adminRole));

                log.info("USER, ADMIN 권한이 추가 되었습니다.");
            } else {
                log.info("권한 정보가 이미 존재합니다.");
            }
        };
    }
}
