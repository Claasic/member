package com.member.service;

import com.member.entity.Member;
import com.member.repository.MemberRepository;
import com.member.request.SaveMemberRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void saveMember(SaveMemberRequest request) {
        memberRepository.save(Member.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build());
    }
}
