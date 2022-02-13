package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaFoodRepository implements FoodRepository {

    private final EntityManager em;

    public JpaFoodRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Food> findByStoreIdx(Long storeIdx) {
        // 객체 자체를 select
        List<Food> result = em.createQuery("select f from Food f where f.storeIdx = :storeIdx", Food.class).setParameter("storeIdx", storeIdx).getResultList();
        return result;
    }
}
