package com.member.entity;

import com.member.request.ModifyMemberRequest;
import com.member.request.SaveMemberRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Builder
    public Member(Long id, String email, String name, String nickname, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
    }

    public void modifyMember(ModifyMemberRequest request) {
        this.nickname = request.getNickname();
        this.password = request.getPassword();
    }

    public static Member of(SaveMemberRequest saveMemberRequest) {
        return Member.builder()
                .email(saveMemberRequest.getEmail())
                .nickname(saveMemberRequest.getNickname())
                .name(saveMemberRequest.getName())
                .password(saveMemberRequest.getPassword())
                .build();
    }

}
