package org.miniproject.restboard.repository;

import org.miniproject.restboard.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name); // 이름으로 롤 정보 꺼내오기
}
