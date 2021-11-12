package com.example.makingboard.application.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PosterVO {

    //poster의 아이디
    private Long id;

    //poster의 제목
    private String title;

    //poster의 사진
    private String imageUrl;

    //포스터의 내용
    private String content;



    /*
    TODO 포스터의 댓글들을 가져오고 싶은데 이렇게 가져오면
    CommentVO처리를 어떻게 해야할까?
    이거 해결되면 PosterOfEntity에 생성자 부분에 따로 추가해줘야함

    포스터의 댓글들
    private List<CommentVO> comments;
     */
}
