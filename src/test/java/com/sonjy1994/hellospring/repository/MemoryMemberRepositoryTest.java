package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 모든 메서드가 끝난 후에 자동적으로 실행되는 메소드
    @AfterEach
    public void afterEach() {
        // 싹 다 날려주는게 왜 필요하냐면 테스트할때 순서에 따라서 
        // 이전 데이터가 저장될 수도 있기 때문에 한번 싹 다 날려주는 메소드 필요
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("sonjy1994");

        repository.save(member);

        // optional에서 값을 꺼내오는건 get
        Member result = repository.findById(member.getId()).get();

        // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("sonjy19941");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sonjy19942");
        repository.save(member2);

        Member result = repository.findByName("sonjy19942").get();

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("sonjy19941");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("sonjy19942");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
