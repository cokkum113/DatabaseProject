package com.example.makingboard.application.member.dto;

import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class MemberResponse {

    private String name;

    private List<CommentEntity> comments;

    private List<PosterEntity> posts;

}
