package com.example.springjdbc.jdbc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class JDBCApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(JDBCApplication.class, args);
    }
    // JBDC 코드를 직접 만드는 것이 아니고, SpringJDBC가 제공하는
    // JDBCTemplate를 이용하면 반복되는 코드는 알아서 만들어 준다.

    // 필드 주입을 통해서 JDBCTemplate를 얻어옴
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        // 1. 입력 (insert) -> UserDaoImpl로 이동
        // String sql = "insert into users (name, email) values (?, ?)";
        // int count = jdbcTemplate.update(sql, "park", "park@gmail.com");
        // System.out.println(count + "건 입력 성공!!");

        // 2. 조회 (select) -> UserDaoImpl로 이동
        // String selectSql = "select * from users";
        // List<User> userList = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(User.class)); // 쿼리 실행 결과를 어디 담을지 알려줘야함
        // // User user = new User();
        // // user.setId(rs.getLong("id"));
        // // user.setName(rs.getString("name"));
        // // return user;
        // // 를 한줄로 가능
        // for (User user : userList) {
        //     System.out.println(user);
        // }

        List<User> allUsers = userDao.findAllUsers();
        System.out.println(allUsers);
        System.out.println(allUsers.size());
    }
}
