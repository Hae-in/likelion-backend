package com.example.springjdbc.springdatajdbc;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table("users") // 테이블명 명시 ⭐
public class User {
    @Id // pk 명시 ⭐️
    private long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    // ID 없이 생성하는 생성자 (id는 자동 증가)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
