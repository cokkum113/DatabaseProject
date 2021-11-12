package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.PosterRequest;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
1. 포스터 생성하기
2. 포스터 수정하기
3. 포스터 삭제하기
 */
@Service
@RequiredArgsConstructor
public class PosterService {

    private final PosterRepository posterRepository;
    private final MemberRepository memberRepository;

    //포스터 생성하기, 저장된 회원만 poster를 만들수 있도록 구현
    @Transactional
    public void createPoster(Long memberId, PosterRequest posterRequest) {
        MemberEntity member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 멤버가 없습니다. 잘못된 memberId = " + memberId));
        posterRepository.save(PosterEntity.builder()
                .memberEntity(member)
                .title(posterRequest.getTitle())
                .content(posterRequest.getContent())
                .imageUrl(posterRequest.getImageUrl())
                .build()
        );
        //TODO 만약 이것 밖에 builder에 안들어간다면 comments는 comment쪽 로직으로 들어가게 구현하는건지

    }

    @Transactional
    public void modifyContent(Long postId, PosterRequest posterRequest) {
        PosterEntity postEntity = posterRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 잘못된 postId = " + postId));
        postEntity.modifyContent(posterRequest.getTitle(), posterRequest.getContent(), posterRequest.getImageUrl());
        //수정하는 것을 바로 entity에 접근하는게 굉장히 위험한 방법인가? 그럼 이것도 VO로 바꿔야하는지?
    }

    @Transactional
    public void deletePoster(Long postId) {
        PosterEntity posterEntity = posterRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. 잘못된 postId = " + postId));
        posterRepository.delete(posterEntity);

    }

}


