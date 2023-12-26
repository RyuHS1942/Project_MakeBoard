package com.example.backend.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.sql.Clob;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    @Comment("게시글 ID")
    private int postId;

    @Comment("게시글 제목")
    private String postTitle;

    //@Lob
    @Comment("게시글 내용")
    //private Clob postContent;
    private String postContent;

    @Comment("게시글 최초 생성자")
    private String createdBy;

    @Comment("게시글 최초 생성날짜")
    private LocalDateTime createdAt;

    @Comment("게시글 최근 수정자")
    private String modifiedBy;

    @Comment("게시글 최근 수정날짜")
    private LocalDateTime modifiedAt;

    /*@ManyToOne
    @Comment("게시판 ID")
    private Board boardId;*/

    public Post(String postTitle, String postContent) {//Clob postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}
