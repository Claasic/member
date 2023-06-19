package com.member.request;

import lombok.Builder;
import lombok.Getter;

@Getter

public class SaveMemberRequest {

    private String email;

    private String name;

    private String nickname;

    private String password;

    private String passwordConfirm;

    @Builder
    public SaveMemberRequest(String email, String name, String nickname, String password, String passwordConfirm) {
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }
}
