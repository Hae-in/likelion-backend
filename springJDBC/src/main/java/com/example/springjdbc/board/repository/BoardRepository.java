package com.example.springjdbc.board.repository;

import com.example.springjdbc.board.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {
}
