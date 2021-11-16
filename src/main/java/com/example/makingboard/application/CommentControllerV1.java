package com.example.makingboard.application;

import com.example.makingboard.application.board.CommentService;
import com.example.makingboard.application.board.PosterService;
import com.example.makingboard.application.board.dto.CommentRequest;
import com.example.makingboard.application.board.dto.CommentResponse;
import com.example.makingboard.application.member.MemberService;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import com.example.makingboard.common.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
1. 댓글 쓰기
2. 댓글 수정하기
3. 유저아이디로 쓴 댓글 모아보기
5. 댓글지우기
 */
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class CommentControllerV1 {

    private CommentService commentService;
    private PosterService posterService;
    private MemberService memberService;

    @PostMapping("/api/v1/comment/{memberId}")
    public ResponseEntity<Void> writeComment(@PathVariable Long memberId, @RequestBody CommentRequest commentRequest) {
        commentService.writeComment(commentRequest);
        return ApiResponse.created(null);
    }

    @PutMapping("/api/v1/comment/{commentId}")
    public ResponseEntity<Void> modifyComment(@PathVariable Long commentId, @RequestBody CommentRequest commentRequest) {
        commentService.modifyComment(commentId, commentRequest);
        return ApiResponse.success(null);
    }

    @DeleteMapping("/api/v1/comment/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ApiResponse.success(null);
    }

    @GetMapping("/api/v1/comment/{memberName}")
    public List<String> allGetCommentWrittenMember(@PathVariable String memberName) {
        return commentService.allGetCommentWrittenMember(memberName);
    }

}


