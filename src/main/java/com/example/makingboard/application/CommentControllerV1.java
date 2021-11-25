package com.example.makingboard.application;

import com.example.makingboard.application.board.CommentService;
import com.example.makingboard.application.board.dto.CommentRequest;
import com.example.makingboard.application.board.dto.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class CommentControllerV1 {

    private final CommentService commentService;

    @GetMapping("/v1/comment/write")
    public String writeComment(@RequestParam("id") Long postId,Model model) {
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setId(postId);
        model.addAttribute("commentRequest", commentRequest);
        return "board/commentWrite";
    }

    @PostMapping("/v1/comment/save")
    public String saveComment(@RequestParam("id") Long postId,CommentRequest commentRequest, Model model) {
         commentService.writeComment(commentRequest,postId);
         List<CommentResponse> commentList = commentService.getCommentList();
         model.addAttribute("commentList", commentList);
         return "board/commentList";

    }

    @PostMapping("/v1/comment/delete")
    public String deleteComment(@RequestParam(value = "commentId") Long id){
        commentService.deleteComment(id);
        return "board/commentList";
    }


}


