package com.example.makingboard.application.member.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class MemberRequest {
    private String name;
    private String email;
    private String password;
}
