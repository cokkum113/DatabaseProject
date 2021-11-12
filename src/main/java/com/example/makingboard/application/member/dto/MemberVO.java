package com.example.makingboard.application.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//회원 조회하면 나오게하는 VO
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberVO {

    //회원의 아이디
    private Long id;

    //회원의 이름
    private String name;


}
