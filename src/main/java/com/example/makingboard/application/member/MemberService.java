package com.example.makingboard.application.member;

import com.amazonaws.services.kms.model.AlreadyExistsException;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import com.example.makingboard.application.member.dto.MemberRequest;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*
1. 회원가입
2. 회원 조회
3. 회원 탈퇴
 */

@Service
@RequiredArgsConstructor
public class MemberService  {
    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberRequest memberRequest) {
        try {
            memberRepository.save(
                    MemberEntity.builder()
                            .name(memberRequest.getName())
                            .email(memberRequest.getEmail())
                            .password(memberRequest.getPassword())
                            .build()
            );
        } catch (Exception e) {
            throw new AlreadyExistsException("이미 있는 유저입니다");
        }

    }

    @Transactional
    public List<MemberEntity> findAllMember() {
        return memberRepository.findAll();
    }

    @Transactional
    public Optional<MemberEntity> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Transactional
    public void deleteMember(Long memberId) {
        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. 잘못된 memberId = " + memberId));
        memberRepository.delete(memberEntity);

    }

}
