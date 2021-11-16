package com.example.makingboard.application.board;

import com.example.makingboard.application.board.change.PosterOfEntity;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.member.MemberService;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/*
보드 서비스에서 할 일
1. 사용자의 이름으로 작성한 포스터들 조회
2. 포스터들을 전체 조회하기
3. (구현 기간 가능하다면) 최신순으로 보여주기
4. (구현 기간 가능하다면) 조회수 많은 순으로 보여주기
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final PosterOfEntity posterOfEntity;
    private final MemberService memberService;


    //사용자의 이름으로 작성한 포스터들 조회
    @Transactional(readOnly = true)
    public PosterResponse getPosters(Long memberId, Long posterId) {
        Optional<MemberEntity> member = memberService.findMemberById(memberId);
        String memberName = member.get().getName();
        PosterResponse posters = posterOfEntity.findPostersByName(memberName);
        return posters;
    }

    //포스터들을 전체 조회하기
    @Transactional(readOnly = true)
    public PosterResponse getAllPosters() {
        PosterResponse allPosters = posterOfEntity.findAllPosters();
        return allPosters;
    }


}

