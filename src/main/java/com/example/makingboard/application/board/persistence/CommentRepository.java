package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByUserName(String userName);
    List<CommentEntity> findAllByCreatedAtBefore(ZonedDateTime createdAt);
}
