package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.PostEntity;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String content;

    public PostResponseDto(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.imageUrl = postEntity.getImageUrl();
        this.content = postEntity.getContent();
    }
}
