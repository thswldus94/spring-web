package com.sonjy1994.hellospring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "pay")
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "order_idx")
    private Long orderIdx;

    @Column(name = "pay_type")
    private Long payType;

    @Column(name = "price")
    private Long price;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

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

    public Long getOrderIdx() {
        return orderIdx;
    }

    public void setOrderIdx(Long orderIdx) {
        this.orderIdx = orderIdx;
    }

    public Long getPayType() {
        return payType;
    }

    public void setPayType(Long payType) {
        this.payType = payType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @PrePersist
    public void setCreatedTime() {
        this.createdTime = LocalDateTime.now();
    }
}