package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Food;
import com.sonjy1994.hellospring.domain.Pay;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaPayRepository implements PayRepository {

    private final EntityManager em;

    public JpaPayRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Pay save(Pay pay) {
        em.persist(pay);
        return pay;
    }

    @Override
    public List<Pay> findAll() {
        // 객체 자체를 select
        return em.createQuery("select o from Order o", Pay.class).getResultList();
    }

    @Override
    public List<Food> findFoodByOrderIdx(Long orderIdx) {
        // 객체 자체를 select
        return em.createNativeQuery("select f.* from order_food as o join food as f on o.food_idx = f.idx where o.order_idx = " + orderIdx.toString(), Food.class).getResultList();
    }
}
