package org.example.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todo.dto.TodoDTO;
import org.example.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    // 추가
    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(@Valid @RequestBody TodoDTO dto) {
        return ResponseEntity.ok(todoService.createTodo(dto));
    }

    // 전체 조회
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    // 조회
    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(todoService.getTodo(id));
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("id") Long id, @Valid @RequestBody TodoDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(todoService.updateTodo(dto));
    }

    // done 상태 변경
    @PatchMapping("/{id}")
    public ResponseEntity<TodoDTO> updateDone(@PathVariable("id") Long id) {
        return ResponseEntity.ok(todoService.updateDone(id));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(id + " is deleted");
    }
}
