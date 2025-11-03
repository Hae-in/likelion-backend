package org.example.todo.dto;

import lombok.*;
import org.example.todo.domain.Todo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDTO {
    private Long id;
    private String todo; // 할 일 내용

    @Builder.Default
    private boolean done = false; // 완료 여부

    // Entity -> DTO
    public static TodoDTO fromEntity(Todo entity) {
        return TodoDTO.builder().id(entity.getId()).todo(entity.getTodo()).done(entity.isDone()).build();
    }
}
