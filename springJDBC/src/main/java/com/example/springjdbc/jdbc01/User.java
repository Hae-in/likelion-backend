package com.example.springjdbc.jdbc01;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
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
