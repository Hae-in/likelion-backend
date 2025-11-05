package org.example.securityexam4.repository;

import org.example.securityexam4.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name); // 이름으로 롤 정보 꺼내오기
}
