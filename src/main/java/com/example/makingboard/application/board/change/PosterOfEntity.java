package com.example.makingboard.application.board.change;

import com.example.makingboard.application.board.dto.PosterResponse;
import com.example.makingboard.application.board.dto.PosterVO;
import com.example.makingboard.application.board.persistence.PosterRepository;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PosterOfEntity {
    private PosterRepository postRepository;


    public PosterVO changePosterEntityToVO(Long id) {
        Optional<PosterEntity> posterEntity = postRepository.findById(id);
        PosterVO poster = new PosterVO(posterEntity.get().getId(), posterEntity.get().getTitle(),posterEntity.get().getImageUrl(), posterEntity.get().getContent());
        return poster;
    }

    public PosterResponse findPostersByName(String name) {
        List<PosterEntity> posterEntities = postRepository.findPostersByMemberName(name);
        PosterResponse postResponse = new PosterResponse();
        for (PosterEntity poster : posterEntities) {
            PosterVO posterVO = new PosterVO(poster.getId(), poster.getTitle(), poster.getImageUrl(), poster.getContent());

            //TODO 왜 postResponse는 List인데 add로 안들어 갈까요...?
            postResponse.add(posterVO);
        }
        return postResponse;
    }

    public PosterResponse findAllPosters() {
        List<PosterEntity> posterEntities = postRepository.findAll();
        PosterResponse postResponse = new PosterResponse();
        for (PosterEntity poster : posterEntities) {
            PosterVO posterVO = new PosterVO(poster.getId(), poster.getTitle(), poster.getImageUrl(), poster.getContent());
            //TODO 위와 같은 문제 , 전체 조회도 똑같이 하면 될거같은데 add가 안되는 게 문제.
            postResponse.add(posterVO);
        }
        return postResponse;
    }
}
