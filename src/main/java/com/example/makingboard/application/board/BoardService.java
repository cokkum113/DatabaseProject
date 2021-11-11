package com.example.makingboard.application.board;
/*
import com.example.makingboard.application.board.dto.PostResponse;
import com.example.makingboard.application.board.persistence.PostRepository;
import com.example.makingboard.application.board.persistence.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponse getPost(Long userId, Long posterId) {
        PostEntity post = Optional.ofNullable(postRepository.getById(posterId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 포스트입니다."));
        return PostResponse.builder()
                .memberId(userId)
                .postId(posterId)
                .content(post.getContent())
                .imageUrl(post.getImageUrl())
                .title(post.getTitle())
                .build();
    }
}


 */