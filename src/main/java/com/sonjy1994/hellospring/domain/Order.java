package com.sonjy1994.hellospring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "`order`") // order는 예약어라서 ` ` 로 감싸주어야 함
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "store_idx")
    private Long storeIdx;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="order_idx")
    private Collection<OrderFood> orderFood;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public Long getStoreIdx() {
        return storeIdx;
    }

    public void setStoreIdx(Long storeIdx) {
        this.storeIdx = storeIdx;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @PrePersist
    public void setCreatedTime() {
        this.createdTime = LocalDateTime.now();
    }


    public Collection<OrderFood> getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(Collection<OrderFood> orderFood) {
        this.orderFood = orderFood;
    }

    public void addOrderFood(OrderFood of) {
        if (orderFood == null) {
            orderFood = new ArrayList<OrderFood>();
        }

        orderFood.add(of);
    }
}