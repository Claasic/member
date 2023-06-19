package com.member.controller;

import com.member.request.ModifyMemberRequest;
import com.member.request.SaveMemberRequest;
import com.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Void> saveMember(SaveMemberRequest request) {
        memberService.saveMember(request);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> modifyMember(ModifyMemberRequest request) {
        return ResponseEntity.ok().build();
    }

}
