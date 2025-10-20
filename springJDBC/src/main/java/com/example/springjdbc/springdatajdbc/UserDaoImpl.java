package com.example.springjdbc.springdatajdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    // 직접 구현!!

    @Override
    public Optional<User> abcUser(String email) {
        System.out.println("직접 구현한 부분이 실행!!!");
        return Optional.empty();
    }


}
