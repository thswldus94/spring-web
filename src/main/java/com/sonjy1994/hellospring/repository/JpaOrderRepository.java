package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Order;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaOrderRepository implements OrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Order save(Order order) {
        em.persist(order);
        return order;
    }

    @Override
    public List<Order> findAll() {
        // 객체 자체를 select
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }
}
