//package com.example.makingboard.application.board;
//
//import com.example.makingboard.application.board.dto.CommentRequest;
//import com.example.makingboard.application.board.persistence.CommentRepository;
//import com.example.makingboard.application.board.persistence.entity.Comment;
//import com.example.makingboard.application.member.MemberService;
//import com.example.makingboard.application.member.persistence.entity.Member;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@RequiredArgsConstructor
//public class CommentService {
//    private final CommentRepository commentRepository;
//    private final MemberService memberService;
//    private final PosterService posterService;
//
//    //댓글 쓰기
//    @Transactional
//    public Long writeComment(CommentRequest commentRequest) {
//        Member author = memberService.getOrCreate(commentRequest.getUserName(), commentRequest.getPassword());
//        Comment comment = commentRequest.toEntity();
//        comment.setAuthor(author);
//        return commentRepository.save(comment).getId();
//    }
//
//    /*
//    댓글수정.
//    @Transactional
//    public CommentResponse modifyComment(Long commentId, CommentRequest commentRequest) {
//        Comment comment  = commentRepository.findById(commentId)
//                .orElseThrow(() -> new IllegalArgumentException("없는 댓글입니다."));
//        comment.modifyComment(commentRequest.getText());
//        return new CommentResponse(comment);
//    }
//     */
//
//
//    //댓글 지우기
//    @Transactional
//    public void deleteComment(Long id){
//        commentRepository.deleteById(id);
//    }
//}
//
