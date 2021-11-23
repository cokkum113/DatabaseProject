package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.Comment;
import com.example.makingboard.application.board.persistence.entity.Poster;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class CommentRequest {

    private String userName;
    private String password;

    //작성하는 내용
    private String text;

    @Builder
    public CommentRequest(String userName, String password,String text) {
        this.userName = userName;
        this.password = password;
        this.text = text;
    }

    public Comment toEntity() {
        return Comment.builder()
                .text(text)
                .build();
    }

}
