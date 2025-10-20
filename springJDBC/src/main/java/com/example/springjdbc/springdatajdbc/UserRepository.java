package com.example.springjdbc.springdatajdbc;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // extends CrudRepository 필수
    // <User, Long>: 엔티티, PK 타입
}
