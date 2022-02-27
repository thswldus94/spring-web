package com.sonjy1994.hellospring.controller.entity;

import java.time.LocalDateTime;
import java.util.List;

public class PayEntity {

    private Long idx;
    private Long userIdx;
    private Long orderIdx;
    private Long payType;
    private Long price;
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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreateTime() {
        this.createdTime = LocalDateTime.now();
    }

    public String toString() {
        return "Pay Entity [userIdx = " + userIdx + " orderIdx = " + orderIdx + " payType = " + payType + " price = " + price+ "]";
    }
}