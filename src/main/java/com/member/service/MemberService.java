package com.member.service;

import com.member.request.ModifyMemberRequest;
import com.member.request.SaveMemberRequest;

public interface MemberService {

    void saveMember(SaveMemberRequest request);

    void modifyMember(Long memberId, ModifyMemberRequest request);
}
