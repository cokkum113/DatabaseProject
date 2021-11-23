//package com.example.makingboard.application.board.persistence;
//
//import com.example.makingboard.application.board.persistence.entity.Comment;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.time.ZonedDateTime;
//import java.util.List;
//
//public interface CommentRepository extends JpaRepository<Comment, Long> {
//    List<Comment> findAllByMemberEntity(Long id);
//
//    List<Comment> findAllByCreatedAtBefore(ZonedDateTime createdAt);
//}