package com.example.backend.board.infrastructure.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReadBoardResponse {
    private int postId;
    private String postTitle;
    private String postContent;
    private String createdBy;
    private LocalDateTime createdAt;
}
