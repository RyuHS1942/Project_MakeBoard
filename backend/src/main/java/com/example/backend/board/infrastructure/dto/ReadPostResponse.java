package com.example.backend.board.infrastructure.dto;

import lombok.Data;

import java.sql.Clob;
import java.time.LocalDateTime;

@Data
public class ReadPostResponse {

    private int postId;
    private String postTitle;
    //private Clob postContent;
    private String postContent;
    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;

    //private int board_id;
}
