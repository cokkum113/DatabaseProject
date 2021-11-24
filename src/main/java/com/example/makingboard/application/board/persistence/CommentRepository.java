package com.example.makingboard.application.board.persistence;

import com.example.makingboard.application.board.persistence.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}