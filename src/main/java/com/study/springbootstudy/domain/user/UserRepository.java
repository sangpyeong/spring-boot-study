package com.study.springbootstudy.domain.user;

public interface UserRepository {
    User findByUsername(String username);
    void save(User user);
}
