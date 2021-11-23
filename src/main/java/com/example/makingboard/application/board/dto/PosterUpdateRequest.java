package com.example.makingboard.application.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PosterUpdateRequest {
    private Long id;
    private String author;
    private String password;
    private String title;
    private String content;

    @Builder
    public PosterUpdateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
