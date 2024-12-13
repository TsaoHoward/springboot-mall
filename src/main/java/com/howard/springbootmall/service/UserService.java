package com.howard.springbootmall.service;

import com.howard.springbootmall.dao.UserDao;
import com.howard.springbootmall.dto.UserLoginRequest;
import com.howard.springbootmall.dto.UserRegisterRequest;
import com.howard.springbootmall.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    User login(UserLoginRequest userLoginRequest);
}
