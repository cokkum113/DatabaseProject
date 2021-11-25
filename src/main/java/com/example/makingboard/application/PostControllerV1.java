package com.example.makingboard.application;

import com.example.makingboard.application.board.CommentService;
import com.example.makingboard.application.board.PosterService;
import com.example.makingboard.application.board.dto.CommentResponse;
import com.example.makingboard.application.board.dto.PosterRequest;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.board.dto.PosterUpdateRequest;
import com.example.makingboard.application.board.persistence.CommentRepository;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.Comment;
import com.example.makingboard.application.board.persistence.entity.Poster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostControllerV1 {

    private final PosterService posterService;


    @GetMapping("/v1/posts")
    public String getPoster(@RequestParam(value = "postId") Long id, Model model) {
        PosterResponse poster = posterService.getPoster(id);
        if (poster == null) {
            return "redirect:/v1/posts/list";
        }
        model.addAttribute("poster", poster);
        return "board/poster";
    }

    @GetMapping(value = "/v1/posts/list")
    public String openPosterList(Model model) {
        List<PosterResponse> posterList = posterService.getPosterList();
        model.addAttribute("posterList", posterList);

        return "board/list";
    }

    @GetMapping("/v1/posts/write")
    public String writePoster(Model model) {
        model.addAttribute("posterRequest", new PosterRequest());

        return "board/write";
    }

    @PostMapping(value = "/v1/posts/save")
    public String savePoster(PosterRequest posterRequest, Model model) {
        posterService.savePoster(posterRequest);
        List<PosterResponse> posterList = posterService.getPosterList();
        model.addAttribute("posterList", posterList);
        return "board/list";
    }


    @PostMapping (value = "/v1/posts/delete")
    public String deletePoster(@RequestParam(value = "postId") Long id){
        posterService.deletePoster(id);
        return "redirect:/v1/posts/list";
    }




    @GetMapping("/v1/posts/update")
    public String updatePoster(@RequestParam("id") Long postId, Model model) {
        PosterUpdateRequest request = new PosterUpdateRequest();
        request.setId(postId);
        model.addAttribute("posterUpdateRequest", request);
        return "board/update";
    }


    @PostMapping(value = "/v1/posts/updateSave")
    public String updatePosterSave(PosterUpdateRequest posterUpdateRequest, Model model) {
        posterService.updatePoster(posterUpdateRequest.getId(), posterUpdateRequest);
        List<PosterResponse> posterList = posterService.getPosterList();
        model.addAttribute("posterList", posterList);
        return "board/list";
   }

}
