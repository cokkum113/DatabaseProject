package com.example.makingboard.application.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Builder
@NoArgsConstructor
public class MemberResponse {
    private String id;
    private String name;
    private String email;
    private String info;
}
