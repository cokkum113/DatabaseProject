package com.example.makingboard.application.board.dto;

import com.example.makingboard.application.board.persistence.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String imageUrl;
    private String content;

    public PostEntity toEntity() {
        PostEntity post = PostEntity.builder()
                .title(title)
                .imageUrl(imageUrl)
                .content(content)
                .build();
        return post;
    }

    @Builder
    public PostSaveRequestDto(String title, String imageUrl, String content) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.content = content;
    }

}
