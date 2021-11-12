package com.example.makingboard.application.member.persistence.entity;

import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import com.example.makingboard.application.board.persistence.entity.PosterEntity;
import com.example.makingboard.common.DefaultEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity extends DefaultEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "info")
    private String info;

    @Column(name = "social_id")
    private String socialId;

    @OneToMany(mappedBy = "memberEntity")
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity")
    private List<PosterEntity> posts = new ArrayList<>();

    @Builder
    public MemberEntity(String name, String email, String info, String socialId, List<CommentEntity> comments, List<PosterEntity> posts) {
        this.name = name;
        this.email = email;
        this.info = info;
        this.socialId = socialId;
        this.comments = comments;
        this.posts = posts;
    }


}
