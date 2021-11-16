package com.example.makingboard.application.member.persistence;

import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


    Optional<MemberEntity> findById(Long id);

    Optional<MemberEntity> findFirstByName(String name);

    Optional<MemberEntity> findByNameAndPassword(String name, String password);



}
