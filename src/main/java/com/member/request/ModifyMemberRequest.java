package com.member.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class ModifyMemberRequest {

    @NotBlank(message = "닉네임 미입력")
    private String nickname;

    @NotBlank(message = "패스워드 미입력")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "숫자, 영문 대소문자, 특수문자를 포함한 8자 이상의 비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "패스워드 확인 미입력")
    private String passwordConfirm;

    @Builder
    public ModifyMemberRequest(String nickname, String password, String passwordConfirm) {
        this.nickname = nickname;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
}
