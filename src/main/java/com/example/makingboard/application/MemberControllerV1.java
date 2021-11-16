package com.example.makingboard.application;

import com.example.makingboard.application.member.MemberService;
import com.example.makingboard.application.member.dto.MemberRequest;
import com.example.makingboard.application.member.dto.MemberResponse;
import com.example.makingboard.application.member.persistence.entity.MemberEntity;
import com.example.makingboard.common.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MemberControllerV1 {
    private final MemberService memberService;

    @PostMapping("api/v1/member")
    public ResponseEntity<Void> createMember(@RequestBody MemberRequest memberRequest) {
        memberService.createMember(memberRequest);
        return ApiResponse.success(null);
    }

    @GetMapping("api/v1/member/{memberId}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long memberId) {
        Optional<MemberEntity> member = memberService.findMemberById(memberId);
        MemberResponse memberResponse = new MemberResponse(member.get().getName(), member.get().getComments(), member.get().getPosts());
        return ApiResponse.success(memberResponse);
    }
    @GetMapping("api/v1/member/findAll")
    public List<MemberEntity> getAllMember() {
        return memberService.findAllMember();
    }

    @DeleteMapping("api/v1/member/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ApiResponse.success(null);
    }
}

