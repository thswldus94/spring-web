package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order store);
    List<Order> findAll();
}
