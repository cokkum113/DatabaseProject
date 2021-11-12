package com.example.makingboard.application.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberCreateRequest {
    private Long id;
    private String name;
    private String email;
    private String info;
    private String socialId;
}
