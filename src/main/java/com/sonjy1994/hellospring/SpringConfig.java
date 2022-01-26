package com.sonjy1994.hellospring;

import com.sonjy1994.hellospring.repository.MemberRepository;
import com.sonjy1994.hellospring.repository.MemoryMemberRepository;
import com.sonjy1994.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 스프링빈에 등록시키기
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
