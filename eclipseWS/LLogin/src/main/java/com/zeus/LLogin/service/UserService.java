package com.zeus.LLogin.service;

import java.util.List;

import com.zeus.LLogin.model.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}