package com.example.makingboard.application.board.persistence.entity;

import com.example.makingboard.application.member.persistence.entity.Member;
import com.example.makingboard.common.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Poster postEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberEntity;

    @Column(name = "text", nullable = false)
    private String text;

    public Comment(Member member, Poster post, String text) {
        this.memberEntity = member;
        this.postEntity = post;
        this.text = text;
    }

    public void modifyComment(String comment) {
        this.text = comment;
    }
}
