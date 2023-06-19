package com.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String nickname;

    private String password;

    @Builder
    public Member(Long id, String email, String name, String nickname, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
    }

}
