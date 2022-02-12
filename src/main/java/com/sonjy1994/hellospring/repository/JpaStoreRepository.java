package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Location;
import com.sonjy1994.hellospring.domain.Store;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaStoreRepository implements StoreRepository {

    private final EntityManager em;

    public JpaStoreRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Store save(Store store) {
        em.persist(store);
        return store;
    }

    @Override
    public List<Store> findAll() {
        // 객체 자체를 select
        return em.createQuery("select s from Store s", Store.class).getResultList();
    }
}
