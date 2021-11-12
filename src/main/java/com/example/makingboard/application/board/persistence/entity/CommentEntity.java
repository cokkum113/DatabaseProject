package com.example.makingboard.application.board.persistence.entity;

import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import com.example.makingboard.common.DefaultEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends DefaultEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PosterEntity postEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @Column(name = "text", nullable = false)
    private String text;

    public CommentEntity(MemberEntity member, PosterEntity post, String text) {
        this.memberEntity = member;
        this.postEntity = post;
        this.text = text;
    }

    public void modifyComment(String comment) {
        this.text = comment;
    }
}
