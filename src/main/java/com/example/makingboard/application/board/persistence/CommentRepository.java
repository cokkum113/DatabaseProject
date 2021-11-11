package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import com.example.makingboard.application.board.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentEntity> findById(Long id);
    List<CommentEntity> findAllByCreatedAtBefore(ZonedDateTime createdAt);
}
