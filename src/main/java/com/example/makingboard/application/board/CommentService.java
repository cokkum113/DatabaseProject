package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.CommentRequest;
import com.example.makingboard.application.board.persistence.CommentRepository;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/*
1. 댓글 쓰기
2. 댓글 수정하기
3. 유저아이디로 쓴 댓글 모아보기
4. TODO 대댓글 달기
5. 댓글지우기
 */
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PosterRepository posterRepository;

    //댓글 쓰기
    @Transactional
    public void writeComment(CommentRequest commentRequest) {
        MemberEntity member = memberRepository.findFirstByName(commentRequest.getName()).get();
        PosterEntity poster = posterRepository.findByPosterId(member.getId());
        commentRepository.save(CommentEntity.builder()
                .memberEntity(member)
                .postEntity(poster)
                .text(commentRequest.getText())
                .build());
    }

    //수정하기
    @Transactional
    public void modifyComment(Long commentId, CommentRequest commentRequest) {
        MemberEntity member = memberRepository.findFirstByName(commentRequest.getName()).get();
        PosterEntity poster = posterRepository.findByPosterId(member.getId());
        List<CommentEntity> comments = poster.getComments();
        for (CommentEntity comment : comments) {
            if (comment.getId() == commentId) {
                comment.modifyComment(commentRequest.getText());
            }
        }

    }

    //멤버이름으로 쓴 댓글 모아보기
    @Transactional
    public List<String> allGetCommentWrittenMember(String memberName) {
        List<CommentEntity> comments = commentRepository.findByUserName(memberName);
        ArrayList<String> allComments = new ArrayList<>();
        for (CommentEntity comment : comments) {
            allComments.add(comment.getText());
        }
        return allComments;
    }

    //댓글 지우기
    @Transactional
    public void deleteComment(Long commentId) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("없는 댓글입니다"));
        commentRepository.delete(comment);
    }
}

