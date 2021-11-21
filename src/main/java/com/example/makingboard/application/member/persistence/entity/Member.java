package com.example.makingboard.application.member.persistence.entity;

import com.example.makingboard.application.board.persistence.entity.Comment;
import com.example.makingboard.application.board.persistence.entity.Poster;
import com.example.makingboard.common.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Poster> posts = new ArrayList<>();

    public Member(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
