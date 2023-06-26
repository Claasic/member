package com.member.fixture;

import com.member.request.SaveMemberRequest;

public class MemberFixture {

    public static final SaveMemberRequest SAVE_SUCCESS_MEMBER = SaveMemberRequest.builder()
            .email("SaveSuccessMember@gmail.com")
            .name("홍길동")
            .nickname("테스트닉네임")
            .password("테스트패스워드@5790")
            .passwordConfirm("테스트패스워드@5790")
            .build();

    public static final SaveMemberRequest EMAIL_BLANK_MEMBER = SaveMemberRequest.builder()
            .name("홍길동")
            .nickname("테스트닉네임")
            .password("테스트패스워드@5790")
            .passwordConfirm("테스트패스워드@5790")
            .build();
}
