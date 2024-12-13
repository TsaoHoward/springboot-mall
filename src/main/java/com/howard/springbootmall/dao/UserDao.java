package com.howard.springbootmall.dao;

import com.howard.springbootmall.dto.UserRegisterRequest;
import com.howard.springbootmall.model.User;
import org.springframework.stereotype.Component;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userid);
}
