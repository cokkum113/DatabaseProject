package com.example.makingboard.application.board;

import com.example.makingboard.application.board.change.MemberOfEntity;
import com.example.makingboard.application.board.change.PosterOfEntity;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.member.dto.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final MemberOfEntity memberOfEntity;
    private final PosterOfEntity posterOfEntity;

    //사용자의 이름으로 작성한 포스터들 조회
    @Transactional(readOnly = true)
    public PosterResponse getPosters(Long memberId, Long posterId) {
        MemberVO member = memberOfEntity.changeMemberEntityToVO(memberId);
        String memberName = member.getName();
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

