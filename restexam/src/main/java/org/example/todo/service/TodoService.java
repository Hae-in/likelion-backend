package org.example.todo.service;

import lombok.RequiredArgsConstructor;
import org.example.todo.domain.Todo;
import org.example.todo.dto.TodoDTO;
import org.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    // 추가
    @Transactional
    public TodoDTO createTodo(TodoDTO todoDTO) {
        // DTO에 들어있는 값을 Entity로 옮겨 담는 과정
        Todo todo = Todo.fromDto(todoDTO);
        Todo savedTodo = todoRepository.save(todo); // Repository에 전달

        return TodoDTO.fromEntity(savedTodo);
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(TodoDTO::fromEntity).toList();
    }

    // 조회
    @Transactional(readOnly = true)
    public TodoDTO getTodo(Long id) {
        // 엔티티로 가져온 값
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found id: " + id));
        return TodoDTO.fromEntity(todo);
    }

    // 수정
    @Transactional
    public TodoDTO updateTodo(TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(todoDTO.getId()).orElseThrow(() -> new RuntimeException("Todo not found id: " + todoDTO.getId()));

        if (todoDTO.getTodo() != null) {
            todo.setTodo(todoDTO.getTodo());
        }

        return TodoDTO.fromEntity(todo);
    }

    // done 상태 변경
    @Transactional
    public TodoDTO updateDone(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found id: " + id));

        todo.setDone(!todo.isDone());

        return TodoDTO.fromEntity(todo);
    }

    // 삭제
    @Transactional
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found id: " + id);
        }
        todoRepository.deleteById(id);
    }
}
