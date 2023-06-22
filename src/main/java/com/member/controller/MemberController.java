package com.member.controller;

import com.member.exception.NotSamePasswordConfirmException;
import com.member.request.ModifyMemberRequest;
import com.member.request.SaveMemberRequest;
import com.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Void> saveMember(@Validated SaveMemberRequest request) {
        validateSamePasswordConfirm(request);
        memberService.saveMember(request);
        return ResponseEntity.ok().build();
    }

    private void validateSamePasswordConfirm(SaveMemberRequest request) throws NotSamePasswordConfirmException {
        if (!request.getPassword().equals(request.getPasswordConfirm())) {
            throw new NotSamePasswordConfirmException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> modifyMember(ModifyMemberRequest request) {
        return ResponseEntity.ok().build();
    }

}
