package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
    private Long id;
    private String userName;
    private String text;

    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.userName = comment.getMember().getName();
        this.text = comment.getText();
    }
}
