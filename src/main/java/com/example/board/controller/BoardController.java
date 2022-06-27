package com.example.board.controller;

import com.example.board.domain.Board;

import com.example.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String login(){

        return "login";
    }

    @GetMapping("/boards")
    public String boards(Model model){

        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);

        return "board";
    }

    @GetMapping("/board")
    public String boardCreatePage(){

        return "board_create";
    }

    @GetMapping("/board/{id}")
    public String viewPost(@PathVariable("id")Long id,
                           Model model){
        Board board =  boardRepository.findById(id).get();
        model.addAttribute("board", board);

        return "board_detail";
    }



}
