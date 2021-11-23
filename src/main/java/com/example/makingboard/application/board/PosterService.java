package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.PosterRequest;
import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.board.dto.PosterUpdateRequest;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.Poster;
import com.example.makingboard.application.member.MemberService;
import com.example.makingboard.application.member.persistence.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PosterService {
    private final MemberService memberService;
    private final PosterRepository posterRepository;


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
        List<Poster> posterList = posterRepository.findAll();
        List<PosterResponse> posterResponseList = new ArrayList<>();

        for (Poster poster : posterList) {
            PosterResponse posterResponse = new PosterResponse(poster);
            posterResponseList.add(posterResponse);
        }
        return posterResponseList;
    }

    @Transactional
    public void deletePoster(Long id) {
        posterRepository.deleteById(id);
    }
}


