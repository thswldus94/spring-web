package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null 이 반환될 가능성이 있는 것들은 optional로 감싸주는게 요즘 추세
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // member에서 이름이 name인 것만 뽑아서 걸러주는 부분
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>((store.values()));
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
