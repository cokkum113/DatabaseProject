package com.example.makingboard.application.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PosterRequest {
    //작성자의 이름
    private String name;

    private String title;

    private String imageUrl;

    private String content;
}
