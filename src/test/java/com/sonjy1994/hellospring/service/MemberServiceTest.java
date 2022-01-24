package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Member;
import com.sonjy1994.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 모든 메서드가 시작하기 전에 자동으로 실행되는 메소드
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 모든 메서드가 끝난 후에 자동적으로 실행되는 메소드
    @AfterEach
    public void afterEach() {
        // 싹 다 날려주는게 왜 필요하냐면 테스트할때 순서에 따라서
        // 이전 데이터가 저장될 수도 있기 때문에 한번 싹 다 날려주는 메소드 필요
        memberRepository.clearStore();
    }

    // 테스트는 한글로 이름 적어도 무방함 ㅋㅋ
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("sonjy1994");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원저장() {
        // given
        Member member1 = new Member();
        member1.setName("sonjy1994");

        Member member2 = new Member();
        member2.setName("sonjy1994");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원임!!");
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원임!!");
//        }

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}