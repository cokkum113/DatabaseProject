package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.CommentResponse;
import com.example.makingboard.application.board.dto.PosterRequest;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.board.dto.PosterUpdateRequest;
import com.example.makingboard.application.board.persistence.CommentRepository;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.Comment;
import com.example.makingboard.application.board.persistence.entity.Poster;
import com.example.makingboard.application.member.MemberService;
import com.example.makingboard.application.member.persistence.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PosterService {
    private final MemberService memberService;
    private final PosterRepository posterRepository;
    private final CommentService commentService;
    private final CommentRepository commentRepository;


    @Transactional
    public Long savePoster(PosterRequest posterRequest) {
        Member author = memberService.getOrCreate(posterRequest.getAuthor(), posterRequest.getPassword());
        Poster poster = posterRequest.toEntity();
        poster.setAuthor(author);
        return posterRepository.save(poster).getId();
    }

    @Transactional
    public PosterResponse updatePoster(Long id, PosterUpdateRequest posterUpdateRequest) {
        Poster poster = posterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 게시물 입니다."));
        poster.update(posterUpdateRequest.getTitle(), posterUpdateRequest.getContent());
        return new PosterResponse(poster);
    }

    @Transactional
    public PosterResponse getPoster(Long id) {
        Poster poster = posterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 게시물 입니다."));
        return new PosterResponse(poster);
    }


    @Transactional
    public List<PosterResponse> getPosterList() {
        return posterRepository.findAll().stream()
                .map(PosterResponse::new).collect(Collectors.toList());
    }


    @Transactional
    public void deletePoster(Long id) {
        Poster poster = posterRepository.findById(id).orElseThrow(RuntimeException::new);
        poster.getComments().forEach(x -> commentService.deleteComment(x.getId()));
    }
}


