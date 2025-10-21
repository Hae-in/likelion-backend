package com.example.springjdbc.board.controller;

import com.example.springjdbc.board.domain.Board;
import com.example.springjdbc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    // 글 목록
    @GetMapping("/list")
    public String listBoards(Model model) {
        Iterable<Board> boards = boardService.getBoardList();
        model.addAttribute("boards", boards);
        return "boards/list";
    }

    // 글 작성 폼
    @GetMapping("/write")
    public String addBoardForm() {
        return "boards/writeform";
    }

    // 글 등록
    @PostMapping("/write")
    public String addBoard(@ModelAttribute Board board) {
        boardService.addBoard(board);
        return "redirect:/boards/list";
    }

    // 글 상세보기
    @GetMapping("/view/{id}")
    public String detailBoard(@PathVariable("id")  long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "boards/detail";
    }

    // 글 수정 폼
    @GetMapping("/update/{id}")
    public String updateBoardForm(@PathVariable("id")  long id, Model model) {
        Board board = boardService.getBoardById(id);
        model.addAttribute("board", board);
        return "boards/updateform";
    }

    // 글 수정
    @PostMapping("/update")
    public String updateBoard(@ModelAttribute Board board) {
        boardService.updateBoard(board);
        return "redirect:/boards/list";
    }

    // 글 삭제
    @GetMapping("/delete/{id}")
    public String deleteBoard(@PathVariable("id")  long id) {
        boardService.deleteBoardById(id);
        return "redirect:/boards/list";
    }
}
