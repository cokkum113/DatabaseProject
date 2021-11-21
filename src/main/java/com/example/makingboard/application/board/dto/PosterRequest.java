package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.Poster;
import lombok.*;

//컨트롤러와 서비스에서 사용할 PosterDTO
@Getter
@NoArgsConstructor
@ToString
@Setter
public class PosterRequest {

    private String title;
    private String content;
    private String author;
    private String password;

    @Builder
    public PosterRequest(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Poster toEntity() {
        return Poster.builder()
                .title(title)
                .content(content)
                .build();
    }
}
