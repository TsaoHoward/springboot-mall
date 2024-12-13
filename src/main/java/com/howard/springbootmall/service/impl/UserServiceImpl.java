package com.howard.springbootmall.service.impl;

import com.howard.springbootmall.dao.UserDao;
import com.howard.springbootmall.dto.UserRegisterRequest;
import com.howard.springbootmall.model.User;
import com.howard.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User userCheck = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if (userCheck != null){
            log.warn("email {} already registered!!!", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {

        return userDao.getUserByEmail(email);
    }
}
