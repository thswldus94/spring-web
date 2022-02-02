package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Member;
import com.sonjy1994.hellospring.repository.MemberRepository;
// import com.sonjy1994.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
// Transactional은 테스트하기 좋도록,
// 예를들어 insert 하는 테스트라면 끝나면 다시 rollback 시켜줌
// db에 영향주는게읎음~
@Transactional
class MemberServiceIntgTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    // 테스트는 한글로 이름 적어도 무방함 ㅋㅋ
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("sonjy1994_123");

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

}