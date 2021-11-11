package com.example.makingboard.application.board;

import com.example.makingboard.application.board.dto.PostResponseDto;
import com.example.makingboard.application.board.dto.PostSaveRequestDto;
import com.example.makingboard.application.board.dto.PostUpdateRequestDto;
import com.example.makingboard.application.board.persistence.PostRepository;
import com.example.makingboard.application.board.persistence.entity.PostEntity;
import com.example.makingboard.application.member.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    /*
    @Transactional
    public void createPost(String title, String content, MultipartFile file, Long memberId) {
        MemberEntity member = Optional.ofNullable(memberRepository.getById(memberId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 사용자입니다."));
        //TODO 멀티파일을 String값으로 저장하고 싶을때 어떻게 해야하는지 스트링 파싱?
        //아니면 Http요청을 보내서 생성 할때는 File로 생성하는거고 다운 받을때는 string으로 받는 것인지.
    }

     */

    @Transactional
    public Long save(PostSaveRequestDto postDto) {
        return postRepository.save(postDto.toEntity()).getId();
    }

    @Transactional
    public Long modifyPost(Long id, PostUpdateRequestDto requestDto) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        postEntity.modifyContent(requestDto.getTitle(), requestDto.getImageUrl(), requestDto.getContent());

        return id;

    }

    public PostResponseDto findById(Long id) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalCallerException("해당 게시글이 없습니다. id = " + id));

        return new PostResponseDto(postEntity);
    }


    @Transactional
    public void deletePost(Long postId) {
        PostEntity post = Optional.ofNullable(postRepository.getById(postId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 포스트입니다"));
        postRepository.delete(post);
    }
}




