package com.example.backend.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Comment("게시판 ID")
    private int boardId;

    @Comment("게시판 제목")
    private String boardTitle;

    @Comment("게시판 최초 생성자")
    private String createdBy;

    @Comment("게시판 최초 생성날짜")
    private LocalDateTime createdAt;

    @Comment("게시판 최근 수정자")
    private String modifiedBy;

    @Comment("게시판 최근 수정날짜")
    private LocalDateTime modifiedAt;
}
