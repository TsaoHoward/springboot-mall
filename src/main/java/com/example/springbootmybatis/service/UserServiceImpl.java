package com.example.springbootmybatis.service;

import com.example.springbootmybatis.dto.UserLoginDto;
import com.example.springbootmybatis.dto.UserRegisterDto;
import com.example.springbootmybatis.mapper.UserMapper;
import com.example.springbootmybatis.po.User;
import com.example.springbootmybatis.po.UserExample;
import com.example.springbootmybatis.vo.UserDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User dtoToModel(UserRegisterDto userRegisterDto){
        User user = new User();
        BeanUtils.copyProperties(userRegisterDto, user);
        return user;
    };

    public UserDetailVo modelToVo(User user){
        UserDetailVo userDetailVo = new UserDetailVo();
        BeanUtils.copyProperties(user, userDetailVo);
        return userDetailVo;
    }

    @Override
    public Integer register(UserRegisterDto userRegisterDto) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(userRegisterDto.getEmail());
        
        List<User> userCheck = userMapper.selectByExample(userExample);
        
        if(!userCheck.isEmpty()){
            log.warn("email {} already registered!!!", userRegisterDto.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        String hashPassword = DigestUtils.md5DigestAsHex(userRegisterDto.getPassword().getBytes());
        userRegisterDto.setPassword(hashPassword);

        return userMapper.insert(dtoToModel(userRegisterDto));
    }

    @Override
    public UserDetailVo getUserById(Integer userId) {
        return modelToVo(userMapper.selectByPrimaryKey(userId));
    }

    @Override
    public UserDetailVo getUserByEmail(String email) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        return modelToVo(userMapper.selectByExample(userExample).get(0));
    }

    @Override
    public UserDetailVo login(UserLoginDto userLoginDto) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(userLoginDto.getEmail());

        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.isEmpty()){
            log.warn("email {} yet registered!!!", userLoginDto.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        User user =userList.get(0);
        userLoginDto.setPassword(DigestUtils.md5DigestAsHex(userLoginDto.getPassword().getBytes()));
        if (user.getPassword().equals(userLoginDto.getPassword())){
            return modelToVo(user);
        }else {
            log.warn("email {} \n" +
                    "wrong password: {} \n" +
                    "correct password: {} ", userLoginDto.getEmail(),userLoginDto.getPassword(), user.getPassword());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
