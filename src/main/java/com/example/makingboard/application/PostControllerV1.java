package com.example.makingboard.application;

import com.example.makingboard.application.board.PostService;
import com.example.makingboard.application.board.S3Service;
import com.example.makingboard.application.board.dto.PostResponseDto;
import com.example.makingboard.application.board.dto.PostSaveRequestDto;
import com.example.makingboard.application.board.dto.PostUpdateRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class PostControllerV1 {

    private S3Service s3Service;
    private PostService postService;


    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto postDto) throws IOException {
        return postService.save(postDto);
    }


    @PutMapping("/api/v1/post/{id}")
    public Long modifyPost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.modifyPost(id, requestDto);
    }


    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }


}
