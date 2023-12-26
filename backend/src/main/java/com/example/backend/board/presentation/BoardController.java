package com.example.backend.board.presentation;

import com.example.backend.board.application.BoardService;
import com.example.backend.board.domain.Post;
import com.example.backend.board.infrastructure.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public void create(@RequestBody CreatePostRequest request) {

        boardService.create(request);
    }

    @GetMapping
    public ResponseEntity<List<ReadBoardResponse>> read() {
        List<ReadBoardResponse> list = boardService.read();

        return ResponseEntity.ok(list);
    }

    @PostMapping("/info")
    public Optional<Post> readInfo(@RequestBody ReadPostRequest request) {
        Optional<Post> post = boardService.readInfo(request);

        return post;
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdatePostRequest request) {
        boardService.update(request);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody ReadPostRequest request) {
        boardService.delete(request);
    }

}
