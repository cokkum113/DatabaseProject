package com.example.makingboard.application.member.persistence.entity;

import com.example.makingboard.application.board.persistence.entity.CommentEntity;
import com.example.makingboard.application.board.persistence.entity.PostEntity;
import com.example.makingboard.application.member.type.SocialProviderType;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "social_provider")
    private SocialProviderType socialProvider;

    @OneToMany(mappedBy = "memberEntity")
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity")
    private List<PostEntity> posts = new ArrayList<>();

    public MemberEntity(String name, String email, String info, String socialId, SocialProviderType socialProvider) {
        this.name = name;
        this.email = email;
        this.info = info;
        this.socialId = socialId;
        this.socialProvider = socialProvider;
    }


}
