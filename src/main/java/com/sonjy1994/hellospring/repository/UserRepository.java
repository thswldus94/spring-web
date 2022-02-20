package com.sonjy1994.hellospring.repository;

import com.sonjy1994.hellospring.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByIdx(Long idx);
    Optional<User> findByUserId(String name);
    List<User> findAll();
}
