package com.example.makingboard.application.member;

import com.example.makingboard.application.member.domain.Member;
import com.example.makingboard.application.member.dto.KakaoProfileResponse;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.type.SocialProviderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final KakaoClient kakaoClient;

    public Member getMember(Long memberId) {
        Member member = memberRepository.getById(memberId);
        return member;
    }


    public Member createMember(String kakaoAccessToken, Member member) {
        KakaoProfileResponse profile = kakaoClient.getProfile(kakaoAccessToken);
        return memberRepository.save(member.asEntity());
    }

    private Member isExist(String socialId, SocialProviderType socialProvider) {
        return memberRepository.existsBySocialIdAndSocialProvider(socialId, socialProvider);
    }
}


 */