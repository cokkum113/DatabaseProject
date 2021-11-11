package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface
PostRepository extends JpaRepository<PostEntity, Long> {
    Optional<PostEntity> findById(Long id);
    List<PostEntity> findAllByCreatedAtBefore(ZonedDateTime createdAt);
    PostEntity findByTitle(String title);
}
