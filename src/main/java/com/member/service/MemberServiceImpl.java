package com.member.service;

import com.member.entity.Member;
import com.member.repository.MemberRepository;
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
}
