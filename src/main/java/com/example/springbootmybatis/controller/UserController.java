package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dto.UserLoginDto;
import com.example.springbootmybatis.dto.UserRegisterDto;
import com.example.springbootmybatis.service.UserService;
import com.example.springbootmybatis.vo.UserDetailVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDetailVo> register(@RequestBody @Validated UserRegisterDto userRegisterDto){
        Integer userId = userService.register(userRegisterDto);
        UserDetailVo userDetailVo = userService.getUserById(userId);

        return ResponseEntity.ok(userDetailVo);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDetailVo> login(@RequestBody @Validated UserLoginDto userLoginDto){

        UserDetailVo userDetailVo = userService.login(userLoginDto);
        return ResponseEntity.ok(userDetailVo);
    }
}
