package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.Poster;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//컨트롤러와 서비스에서 사용할 PosterDTO
@Getter
@NoArgsConstructor
public class PosterRequest {

    private String title;
    private String content;
    private String author;

    @Builder
    public PosterRequest(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Poster toEntity() {
        return Poster.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
