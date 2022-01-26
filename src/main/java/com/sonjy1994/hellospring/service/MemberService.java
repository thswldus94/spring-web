package com.sonjy1994.hellospring.service;

import com.sonjy1994.hellospring.domain.Member;
import com.sonjy1994.hellospring.repository.MemberRepository;
import com.sonjy1994.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 스프링이 뜰때 서비스임을 인지하고 스프링 컨테이너에 등록
// @Service
public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // consturct 역할
    // Autowired는 생성자에 적어줘야 함
    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    * 회원 가입
    * */
    public Long join(Member member) {
        // 중복 이름은 안됨 걸러내야됨
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원임!!");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
