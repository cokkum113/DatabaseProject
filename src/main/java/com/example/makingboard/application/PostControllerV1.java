package com.example.makingboard.application;

import com.example.makingboard.application.board.BoardService;
import com.example.makingboard.application.board.PosterService;
import com.example.makingboard.application.board.S3Service;
import com.example.makingboard.application.board.dto.PosterRequest;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.board.dto.PosterVO;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import com.example.makingboard.common.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
1. 포스터 생성하기
2. 포스터 수정하기
3. 포스터 삭제하기
 */
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
public class PostControllerV1 {

    private S3Service s3Service;
    private PosterService posterService;
    private BoardService boardService;


    @PostMapping("/api/v1/post/{memberId}")
    public ResponseEntity<Void> createPoster(@PathVariable Long memberId, @RequestBody PosterRequest posterRequest) throws IOException {
        posterService.createPoster(memberId, posterRequest);
        return ApiResponse.created(null);
    }


    @PutMapping("/api/v1/post/{posterId}")
    public ResponseEntity<Void> modifyPost(@PathVariable Long posterId, @RequestBody PosterRequest posterRequest) {
        posterService.modifyContent(posterId, posterRequest);
        return ApiResponse.success(null);

    }

    @DeleteMapping("/api/v1/post/{posterId}")
    public ResponseEntity<Void> deletePoster(@PathVariable Long posterId) {
        posterService.deletePoster(posterId);
        return ApiResponse.success(null);
    }

    @GetMapping("/api/v1/post/{posterId}")
    public ResponseEntity<PosterResponse> getPoster(@PathVariable Long memberId, @PathVariable Long posterId) {
        PosterResponse posters = boardService.getPosters(memberId, posterId);
        return ApiResponse.success(posters);
    }

    @GetMapping("/api/v1/post")
    public ResponseEntity<PosterResponse> getAllPosters() {
        PosterResponse allPosters = boardService.getAllPosters();
        return ApiResponse.success(allPosters);
    }




}
