package com.example.springjdbc.jdbc01;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // final 붙은 필드만 생성자로 받음
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate; // DI 받아야함 (1. 생성자, 2. 설정자, 3. 필드)

    // 생성자로 주입 -> @RequiredArgsConstructor 롬볻으로 해결
    // public UserDaoImpl(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @Override
    public void insert(User user) {
        // 1. 입력 (insert)
        String sql = "insert into users (name, email) values (?, ?)";
        int count = jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
        // 2. 조회 (select)
        String selectSql = "select * from users";
        List<User> userList = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(User.class));

        return userList;
    }
}
