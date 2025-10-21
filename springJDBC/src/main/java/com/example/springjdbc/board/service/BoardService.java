package com.example.springjdbc.board.service;

import com.example.springjdbc.board.domain.Board;
import com.example.springjdbc.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Board addBoard(Board board) {
        board.setCreatedAt(LocalDateTime.now());
        return boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Iterable<Board> getBoardList() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Board getBoardById(long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Board updateBoard(Board board) {
        board.setUpdatedAt(LocalDateTime.now());
        return boardRepository.save(board);
    }

    @Transactional
    public void deleteBoardById(long id) {
        boardRepository.deleteById(id);
    }
}
