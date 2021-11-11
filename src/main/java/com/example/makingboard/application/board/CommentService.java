package com.example.makingboard.application.board;
/*
import com.example.makingboard.application.board.persistence.CommentRepository;
import com.example.makingboard.application.board.persistence.PostRepository;
import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import com.example.makingboard.application.board.persistence.entity.PostEntity;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void writeComment(Long memberId, Long postId, String text) {
        MemberEntity member = Optional.ofNullable(memberRepository.getById(memberId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 사용자입니다."));
        PostEntity post = Optional.ofNullable(postRepository.getById(postId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 포스트입니다"));
        CommentEntity comment = new CommentEntity(member, post, text);
        commentRepository.save(comment);
    }

    @Transactional
    public void modifyComment(Long postId, String text, Long commentId) {
        PostEntity post = Optional.ofNullable(postRepository.getById(postId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "없는 포스트입니다."));
        List<CommentEntity> comments = post.getComments();
        for (CommentEntity comment : comments) {
            if (comment.getId() == commentId) {
                comment.modifyComment(text);
            }
        }
    }

    @Transactional
    public void deleteComment(Long commentId) {
        CommentEntity comment = Optional.ofNullable(commentRepository.getById(commentId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "없는 댓글입니다"));
        commentRepository.delete(comment);
    }
}
*/
