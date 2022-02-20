package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<User> findByIdx(Long idx) {
        User user = em.find(User.class, idx);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        List<User> result = em.createQuery("select u from User u where u.userId = :userId", User.class).setParameter("userId", userId).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
        // 객체 자체를 select
        return em.createQuery("select u from User u", User.class).getResultList();
    }
}
