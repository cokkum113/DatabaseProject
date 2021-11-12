package com.example.makingboard.application.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//댓글들 조회하면 돌려줄 수 있게 만든 VO
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentVO {

    //댓글의 아이디
    private Long id;

    //댓글의 유저이름
    private String name;

    //댓글의 내용
    private String text;
}
