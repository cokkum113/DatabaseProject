package com.example.makingboard.application.member.domain;


import com.example.makingboard.application.member.dto.KakaoProfileResponse;
import com.example.makingboard.application.member.dto.MemberResponse;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;

public class Member {
    private String name;
    private String email;
    private String socialId;
    private String socialProvider;

    public static Member valueOf(KakaoProfileResponse reponse) {
        return null;
    }

    public MemberEntity asEntity() {
        return null;
    }

    public MemberResponse asResponse() {
        return null;
    }
}
