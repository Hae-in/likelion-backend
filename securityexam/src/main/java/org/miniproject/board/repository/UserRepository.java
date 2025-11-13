package org.miniproject.board.repository;

import org.miniproject.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLoginId(String loginId); // 엔티티에서 private String username; 으로 선언
    // User findByUserName(String username); // 엔티티에서 private String usernName; 으로 선언
    boolean existsByLoginId(String loginId);
}
