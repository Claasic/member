package com.member.service;

import com.member.request.SaveMemberRequest;
import org.springframework.stereotype.Service;

public interface MemberService {

    void saveMember(SaveMemberRequest request);
}
