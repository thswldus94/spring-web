package com.sonjy1994.hellospring.controller.entity;

import java.time.LocalDateTime;
import java.util.List;

public class OrderEntity {
    private Long userIdx;
    private Long storeIdx;
    private List<Long> foodIdxList;
    private LocalDateTime createdTime;

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

//    public Long getFoodIdx() {
//        return foodIdx;
//    }
//
//    public void setFoodIdx(Long foodIdx) {
//        this.foodIdx = foodIdx;
//    }


    public List<Long> getFoodIdxList() {
        return foodIdxList;
    }

    public void setFoodIdxList(List<Long> foodIdxList) {
        this.foodIdxList = foodIdxList;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreateTime() {
        this.createdTime = LocalDateTime.now();
    }

    public String toString() {
        return "Order Entity [userIdx = " + userIdx + " storeIdx = " + storeIdx + " foodIdxList = " + foodIdxList + "]";
    }
}
