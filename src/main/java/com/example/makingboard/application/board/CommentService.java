package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.CommentRequest;
import com.example.makingboard.application.board.dto.CommentResponse;
import com.example.makingboard.application.board.persistence.CommentRepository;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.Comment;
import com.example.makingboard.application.board.persistence.entity.Poster;
import com.example.makingboard.application.member.MemberService;
import com.example.makingboard.application.member.persistence.MemberRepository;
import com.example.makingboard.application.member.persistence.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PosterRepository posterRepository;
    private final MemberService memberService;

    //댓글 쓰기
    @Transactional
    public CommentResponse writeComment(CommentRequest commentRequest, Long posterId) {
        Member member = memberService.getOrCreate(commentRequest.getUserName(), commentRequest.getPassword());
        Optional<Poster> poster = posterRepository.findById(posterId);
        Comment comment = new Comment().builder()
                .post(poster.get())
                .member(member)
                .text(commentRequest.getText())
                .build();
        commentRepository.save(comment);
        return new CommentResponse(comment);

    }
    @Transactional
    public List<CommentResponse> getCommentList() {
        List<Comment> commentList = commentRepository.findAll();
        List<CommentResponse> commentResponseList = new ArrayList<>();

        for (Comment comment : commentList) {
            CommentResponse commentResponse = new CommentResponse(comment);
            commentResponseList.add(commentResponse);
        }
        return commentResponseList;
    }


    //댓글 지우기
    @Transactional
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}

