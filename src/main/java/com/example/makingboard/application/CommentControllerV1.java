//package com.example.makingboard.application;
//
//import com.example.makingboard.application.board.CommentService;
//import com.example.makingboard.application.board.dto.CommentRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//
//
//@Controller
//@RequiredArgsConstructor
//public class CommentControllerV1 {
//
//    private final CommentService commentService;
//
//    @GetMapping("/v1/comment/write")
//    public String writeComment(Model model) {
//        model.addAttribute("commentRequest", new CommentRequest());
//        return "/board/commentWrite";
//    }
//
//
//}
//
//
