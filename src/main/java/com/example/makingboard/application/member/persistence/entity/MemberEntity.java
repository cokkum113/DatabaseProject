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

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "memberEntity")
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity")
    private List<PosterEntity> posts = new ArrayList<>();

    @Builder
    public MemberEntity(String name, String email, String password, List<CommentEntity> comments, List<PosterEntity> posts) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.comments = comments;
        this.posts = posts;
    }


}
