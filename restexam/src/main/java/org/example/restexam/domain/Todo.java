package org.example.restexam.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.restexam.dto.TodoDTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo; // 할 일 내용
    private boolean done; // 완료 여부

    // DTO -> Entity
    public static Todo fromDto(TodoDTO dto) {
        return Todo.builder().id(dto.getId()).todo(dto.getTodo()).done(dto.isDone()).build();
    }
}
