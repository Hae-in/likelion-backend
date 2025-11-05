package org.example.securityexam4.repository;

import org.example.securityexam4.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // 엔티티에서 private String username; 으로 선언
    // User findByUserName(String username); // 엔티티에서 private String usernName; 으로 선언
    boolean existsByUsername(String username);
}
