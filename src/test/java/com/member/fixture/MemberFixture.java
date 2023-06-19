package com.member.fixture;

import com.member.request.SaveMemberRequest;

public class MemberFixture {

    public static final SaveMemberRequest SAVE_SUCCESS_MEMBER = SaveMemberRequest.builder()
            .email("SaveSuccessMember@gmail.com")
            .name("테스트계정")
            .nickname("테스트닉네임")
            .password("테스트패스워드@5790")
            .passwordConfirm("테스트패스워드@5790")
            .build();
}
