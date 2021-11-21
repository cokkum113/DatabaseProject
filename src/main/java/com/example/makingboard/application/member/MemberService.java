package com.example.makingboard.application.member;

import antlr.StringUtils;
import com.example.makingboard.application.member.persistence.entity.Member;
import com.example.makingboard.application.member.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
1. 회원가입
2. 회원 조회
3. 회원 탈퇴
 */

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member getOrCreate(String name, String password) {
        Optional<Member> member = memberRepository.findFirstByName(name);
        if(member.isPresent()) {
            if(member.get().getPassword().equals(password)) {
                throw new RuntimeException("Password is wrong");
            }
            return member.get();
        } else {
            return createMember(name, password);
        }
    }

    public Member createMember(String name, String password) {
        boolean isExist = memberRepository.existsByName(name);
        if(isExist) {
            throw new RuntimeException("Can not create the member with the name");
        }
        Member newMember = new Member(name, password);
        return memberRepository.save(newMember);
    }
}
