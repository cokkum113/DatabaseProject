package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.Poster;
import com.example.makingboard.application.member.persistence.entity.Member;
import lombok.Getter;

@Getter
public class PosterResponse {
    private Long id;
    private String title;
    private String content;
    private String author;



    public PosterResponse(Poster poster) {
        this.id = poster.getId();
        this.title = poster.getTitle();
        this.content = poster.getContent();
        this.author = poster.getMember().getName();
    }

}
