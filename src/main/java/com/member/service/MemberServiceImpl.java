package com.member.service;

import com.member.entity.Member;
import com.member.exception.MemberNotFindException;
import com.member.repository.MemberRepository;
import com.member.request.ModifyMemberRequest;
import com.member.request.SaveMemberRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void saveMember(SaveMemberRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        memberRepository.save(Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(encoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build());
    }

    @Override
    public void modifyMember(Long memberId, ModifyMemberRequest request) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(() ->
                new MemberNotFindException("회원이 존재하지 않습니다."));
        findMember.modifyMember(request);
    }
}
