package com.sonjy1994.hellospring.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @PrePersist
    public void setCreatedTime() {
        this.createdTime = LocalDateTime.now();
    }
}
