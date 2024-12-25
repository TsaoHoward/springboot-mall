package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.UserRegisterDto;
import com.example.springbootmybatis.dto.UserLoginDto;
import com.example.springbootmybatis.vo.UserDetailVo;

public interface UserService {

    Integer register(UserRegisterDto userRegisterDto);

    UserDetailVo getUserById(Integer userId);

    UserDetailVo getUserByEmail(String email);

    UserDetailVo login(UserLoginDto userLoginDto);
}
