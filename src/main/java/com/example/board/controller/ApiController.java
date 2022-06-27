package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.domain.Member;

import com.example.board.repository.BoardRepository;
import com.example.board.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public Boolean posts(@RequestParam(value = "id" , required = false)String id,
                        @RequestParam(value = "password" , required = false)String password
                        ){

        if ( memberRepository.findById(id).isPresent() ){
            Member member = memberRepository.findById(id).get();
            if ( member.getPassword().equals(password) ){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @PostMapping("/board")
    public Boolean post(@RequestBody Board board){
        System.out.println("board = " + board);

        board.setDate( LocalDate.now()  );

        boardRepository.save(board);

        return true;
    }

    @DeleteMapping("/board")
    public Boolean deletePost(@RequestParam(value = "boardId", required = false) String boardId){

        boardRepository.deleteById(Long.valueOf(boardId));

        return true;
    }

    @PatchMapping("/board")
    public Boolean upViews(@RequestParam(value = "memberId") String memberId,
                           @RequestParam(value = "boardId") Long boardId){

        Board board = boardRepository.findById(boardId).get();

        if (memberRepository.findById(memberId).isPresent()){
            if ( memberRepository.findById(memberId).get().getRole() ){
                board.setRoleView( board.getRoleView() + 1 );
            }else{
                board.setView( board.getView() + 1 );
            }
        }else{
            board.setView( board.getView() + 1 );
        }

        boardRepository.save(board);

        return true;
    }

    @PatchMapping("/board/good/{boardId}")
    public Boolean upGoods( @PathVariable("boardId") String boardId ){

        Board board = boardRepository.findById(Long.valueOf(boardId)).get();

        board.setGood( board.getGood()+1 );

        boardRepository.save(board);


        return true;

    }



}
