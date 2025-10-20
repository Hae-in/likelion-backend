package com.example.springjdbc.springdatajdbc;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>, UserDao {
    // extends CrudRepository 필수
    // <User, Long>: 엔티티, PK 타입

    User findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByNameAndEmail(String name, String email); // select * from users where name = ? and email = ?
}
