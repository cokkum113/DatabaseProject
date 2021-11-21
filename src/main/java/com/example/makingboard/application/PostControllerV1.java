package com.example.makingboard.application;

import com.example.makingboard.application.board.PosterService;
import com.example.makingboard.application.board.dto.PosterRequest;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.board.persistence.entity.Poster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
1. 포스터 생성하기
2. 포스터 수정하기
3. 포스터 삭제하기
 */
@Controller
@RequiredArgsConstructor
public class PostControllerV1 {

    private final PosterService posterService;

//    @PostMapping("/api/v1/posts")
//    public Long savePoster(@RequestBody PosterRequest posterRequest) {
//        return posterService.savePoster(posterRequest);
//    }
//
//    @PutMapping("/api/v1/posts/{postId}")
//    public Long updatePoster(@PathVariable Long postId, @RequestBody PosterUpdateRequest posterUpdateRequest) {
//        return posterService.updatePoster(postId, posterUpdateRequest);
//    }
//
//    @GetMapping("/api/v1/posts/{postId}")
//    public PosterResponse getPoster(@PathVariable Long postId) {
//        return posterService.getPoster(postI);
//    }

    @GetMapping("/v1/posts/{postId}")
    public String getPoster(@PathVariable(value = "postId", required = false) Long id, Model model) {
        PosterResponse poster = posterService.getPoster(id);
        if (poster == null) {
            return "redirect:/board/list";
        }
        model.addAttribute("poster", poster);
        return "board/poster";
    }

    @PostMapping(value = "/v1/posts")
    public String writePoster(@RequestBody PosterRequest posterRequest, Model model) {
        model.addAttribute(posterService.savePoster(posterRequest));
        return "redirect:/board/write";
    }

    @GetMapping(value = "/v1/posts/list")
    public String openBoardList(Model model) {
        List<PosterResponse> posterList = posterService.getPosterList();
        model.addAttribute("posterList", posterList);

        return "board/list";
    }

    @DeleteMapping(value = "/v1/posts/{postId}")
    public String deletePoster(@PathVariable(value = "postId", required = false) Long id){
        posterService.deletePoster(id);
        return "redirect:/board/list";
    }
}
