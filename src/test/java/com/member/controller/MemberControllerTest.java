package com.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.member.fixture.MemberFixture;
import com.member.request.SaveMemberRequest;
import com.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
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

    @Test
    @DisplayName("회원가입 성공")
    void saveMemberSuccess() throws Exception {

        //given
        SaveMemberRequest req = MemberFixture.SAVE_SUCCESS_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 실패 - 이메일 누락")
    void saveMemberFailEmailEmpty() throws Exception {

        //given
        SaveMemberRequest req = MemberFixture.EMAIL_BLANK_MEMBER;
        String json = objectMapper.writeValueAsString(req);

        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

}