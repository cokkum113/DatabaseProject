//package com.example.makingboard.application.board.persistence;
//
//import com.example.makingboard.application.board.persistence.entity.CommentEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.time.ZonedDateTime;
//import java.util.List;
//
//public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
//    List<CommentEntity> findAllByMemberEntity(Long id);
//
//    List<CommentEntity> findAllByCreatedAtBefore(ZonedDateTime createdAt);
//}