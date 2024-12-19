package com.example.springbootmybatis.service;

import com.example.springbootmybatis.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    Integer count();
    List<User> findAll();
}

