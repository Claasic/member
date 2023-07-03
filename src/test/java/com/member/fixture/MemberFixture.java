package com.member.fixture;

import com.member.request.ModifyMemberRequest;
import com.member.request.SaveMemberRequest;

public class MemberFixture {

    public static final SaveMemberRequest SAVE_SUCCESS_MEMBER = SaveMemberRequest.builder()
            .email("SaveSuccessMember@gmail.com")
            .name("홍길동")
            .nickname("테스트닉네임")
            .password("Test@5790")
            .passwordConfirm("Test@5790")
            .build();

    public static final SaveMemberRequest EMAIL_BLANK_MEMBER = SaveMemberRequest.builder()
            .name("홍길동")
            .nickname("테스트닉네임")
            .password("Test@5790")
            .passwordConfirm("Test@5790")
            .build();

    public static final SaveMemberRequest NOT_EMAIL_PATTERN_MEMBER = SaveMemberRequest.builder()
            .email("SaveSuccessMemberGmail.com")
            .name("홍길동")
            .nickname("테스트닉네임")
            .password("Test@5790")
            .passwordConfirm("Test@5790")
            .build();

    public static final SaveMemberRequest NICKNAME_BLANK_MEMBER = SaveMemberRequest.builder()
            .email("test@gmail.com")
            .name("홍길동")
            .password("Test@5790")
            .passwordConfirm("Test@5790")
            .build();

    public static final SaveMemberRequest NAME_BLANK_MEMBER = SaveMemberRequest.builder()
            .email("test@gmail.com")
            .nickname("테스트닉네임")
            .password("Test@5790")
            .passwordConfirm("Test@5790")
            .build();

    public static final SaveMemberRequest PASSWORD_BLANK_MEMBER = SaveMemberRequest.builder()
            .email("test@gmail.com")
            .nickname("테스트닉네임")
            .name("홍길동")
            .passwordConfirm("Test@5790")
            .build();

    public static final SaveMemberRequest PASSWORD_NOT_PATTERN_MEMBER = SaveMemberRequest.builder()
            .email("test@gmail.com")
            .nickname("테스트닉네임")
            .name("홍길동")
            .password("test@5790")
            .passwordConfirm("test@5790")
            .build();

    public static final SaveMemberRequest PASSWORD_CONFIRM_BLANK_MEMBER = SaveMemberRequest.builder()
            .email("test@gmail.com")
            .nickname("테스트닉네임")
            .name("홍길동")
            .password("Test@5790")
            .build();

    public static final ModifyMemberRequest MODIFY_SUCCESS_MEMBER_REQUEST = ModifyMemberRequest.builder()
            .nickname("테스트 수정 성공 닉네임")
            .password("Test@5790")
            .passwordConfirm("Test@5790")
            .build();
}
