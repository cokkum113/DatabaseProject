package com.example.makingboard.application.board.change;

import com.example.makingboard.application.member.dto.MemberVO;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberOfEntity {

    private MemberRepository memberRepository;

    public MemberVO changeMemberEntityToVO(Long id) {
        MemberEntity memberEntity = memberRepository.findMemberById(id);
        MemberVO member = new MemberVO(memberEntity.getId(), memberEntity.getName());
        return member;
    }

}
