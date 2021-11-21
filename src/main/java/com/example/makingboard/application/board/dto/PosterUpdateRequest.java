package com.example.makingboard.application.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PosterUpdateRequest {
    private String title;
    private String content;

    @Builder
    public PosterUpdateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
