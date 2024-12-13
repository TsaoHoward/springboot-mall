package com.howard.springbootmall.controller;

import com.howard.springbootmall.constant.ProductCategory;
import com.howard.springbootmall.dto.ProductQueryParams;
import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.dto.UserLoginRequest;
import com.howard.springbootmall.dto.UserRegisterRequest;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.model.User;
import com.howard.springbootmall.service.UserService;
import com.howard.springbootmall.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Validated UserRegisterRequest userRegisterRequest) throws Exception {

        Integer userId = userService.register(userRegisterRequest);
        User newUser = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Validated UserLoginRequest userLoginRequest){

        User user = userService.login(userLoginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}
