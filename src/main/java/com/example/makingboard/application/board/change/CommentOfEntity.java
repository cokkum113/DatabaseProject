package com.example.makingboard.application.board.change;

import com.example.makingboard.application.board.dto.CommentVO;
import com.example.makingboard.application.board.persistence.CommentRepository;
import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentOfEntity {

    private CommentRepository commentRepository;

    public CommentVO changeCommentEntityToVO(Long id) {
        CommentEntity commentEntity = commentRepository.getById(id);
        CommentVO comment = new CommentVO(commentEntity.getId(), commentEntity.getMemberEntity().getName(), commentEntity.getText());
        return comment;
    }
}
