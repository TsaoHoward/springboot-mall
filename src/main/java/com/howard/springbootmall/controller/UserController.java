package com.howard.springbootmall.controller;

import com.howard.springbootmall.constant.ProductCategory;
import com.howard.springbootmall.dto.ProductQueryParams;
import com.howard.springbootmall.dto.ProductRequest;
import com.howard.springbootmall.dto.UserRegisterRequest;
import com.howard.springbootmall.model.Product;
import com.howard.springbootmall.model.User;
import com.howard.springbootmall.service.UserService;
import com.howard.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<User> register(@RequestBody @Validated UserRegisterRequest userRegisterRequest){

        Integer userId = userService.register(userRegisterRequest);
        User newUser = userService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


}