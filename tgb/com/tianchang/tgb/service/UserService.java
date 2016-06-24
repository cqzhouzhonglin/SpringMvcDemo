package com.tianchang.tgb.service;

import java.util.List;

import com.tianchang.tgb.model.User;

public interface UserService {
    int save(User user);

    int update(User user);

    int delete(int id);

    User findById(int id);

    List<User> findAll();
}
