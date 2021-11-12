package com.example.makingboard.application.member.dto;

import com.example.makingboard.application.board.dto.CommentVO;
import com.example.makingboard.application.board.dto.PosterVO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private Long id;
    private String name;
    private String email;
    private String info;
    private String socialId;

    private List<CommentVO> comments = new ArrayList<>();
    private List<PosterVO> posts = new ArrayList<>();

}
