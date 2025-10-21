package com.example.springjdbc.board.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
    @Id
    private long id;
    private String name;
    private String title;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
