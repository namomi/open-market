package com.openmarket.service;

import com.openmarket.dto.MemberFormDto;
import com.openmarket.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void saveMemberTest(){
        //given
        Member member = createMember();

        //when
        Member savedMember = memberService.saveMember(member);
        //then
        assertThat(savedMember.getName()).isEqualTo(member.getName());
        assertThat(savedMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(savedMember.getPassword()).isEqualTo(member.getPassword());
        assertThat(savedMember.getAddress()).isEqualTo(member.getAddress());
        assertThat(savedMember.getRole()).isEqualTo(member.getRole());

    }
    
    @Test
    public void saveDuplicateMemberTest(){
        //given
        Member member1 = createMember();
        Member member2 = createMember();

        //when
        memberService.saveMember(member1);
        
        //then
        assertThatThrownBy(() -> memberService.saveMember(member2))
                .isInstanceOf(IllegalStateException.class);
    }

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("test");
        memberFormDto.setEmail("test@gmail.com");
        memberFormDto.setPassword("1234");
        memberFormDto.setAddress("경기도 양촌읍");
        return Member.createMember(memberFormDto, passwordEncoder);
    }

}