package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PosterRepository extends JpaRepository<PosterEntity, Long> {
    List<PosterEntity> findPostersByMemberName(String name);
    PosterEntity findByPosterId(Long posterId);
}
