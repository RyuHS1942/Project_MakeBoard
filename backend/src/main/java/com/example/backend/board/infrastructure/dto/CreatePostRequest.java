package com.example.backend.board.infrastructure.dto;

import com.example.backend.board.domain.Board;
import lombok.Builder;
import lombok.Data;

import java.sql.Clob;
import java.time.LocalDateTime;

@Data
//@Builder
public class CreatePostRequest {
    private int postId;
    private String postTitle;
    //private Clob postContent;
    private String postContent;
    //private int board_id;
}
