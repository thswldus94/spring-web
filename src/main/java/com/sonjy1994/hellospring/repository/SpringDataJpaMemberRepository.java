package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // findByXXX 이런식으로 하면 XXX 가지고 알아서 찾아줌
    // findByEmail email = :email 이런식으로
    @Override
    Optional<Member> findByName(String name);
}
