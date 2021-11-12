package com.example.makingboard.application.member.persistence;

import com.example.makingboard.application.member.dto.MemberVO;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import com.example.makingboard.application.member.type.SocialProviderType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findMemberById(Long id);
    MemberEntity findByName(String name);
}
