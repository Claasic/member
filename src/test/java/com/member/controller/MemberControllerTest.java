package com.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.member.fixture.MemberFixture;
import com.member.request.SaveMemberRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    private RestDocumentationContextProvider restDocumentation;

    @Test
    @DisplayName("회원가입 성공")
    void saveMemberSuccess() throws Exception {

        //given
        SaveMemberRequest req = MemberFixture.SAVE_SUCCESS_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("회원가입 실패 - 이메일 형식 실패")
    void saveMemberFailEmailPattern() throws Exception {

        //given
        SaveMemberRequest req = MemberFixture.NOT_EMAIL_PATTERN_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("email"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("형식에 맞지 않은 이메일"))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    @DisplayName("회원가입 실패 - 이메일 누락")
    void saveMemberFailBlankEmail() throws Exception {

        //given
        SaveMemberRequest req = MemberFixture.EMAIL_BLANK_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("email"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("이메일 미입력"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 실패 - 닉네임 누락")
    void saveMemberFailBlankNickname () throws Exception {

        //given
        SaveMemberRequest req = MemberFixture.NICKNAME_BLANK_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("nickname"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("닉네임 미입력"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 실패 - 이름 미입력")
    void saveMemberFailBlankName () throws Exception {
        //given
        SaveMemberRequest req = MemberFixture.NAME_BLANK_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("이름 미입력"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 실패 - 패스워드 미입력")
    void saveMemberFailBlankPassword () throws Exception {
        //given
        SaveMemberRequest req = MemberFixture.PASSWORD_BLANK_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("패스워드 미입력"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 실패 - 패스워드 패턴 검증 실패")
    void saveMemberFailNotValidatedPatternPassword () throws Exception {
        //given
        SaveMemberRequest req = MemberFixture.PASSWORD_NOT_PATTERN_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("숫자, 영문 대소문자, 특수문자를 포함한 8자 이상의 비밀번호를 입력해주세요."))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 실패 - 패스워드 확인 미입력")
    void saveMemberFailBlankPasswordConfirm () throws Exception {
        //given
        SaveMemberRequest req = MemberFixture.PASSWORD_CONFIRM_BLANK_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Validated Error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].field").value("passwordConfirm"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors[*].message").value("패스워드 확인 미입력"))
                .andDo(MockMvcResultHandlers.print());
    }
}