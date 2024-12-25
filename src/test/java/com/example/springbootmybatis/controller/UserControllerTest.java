package com.example.springbootmybatis.controller;
import com.example.springbootmybatis.dto.UserLoginDto;
import com.example.springbootmybatis.dto.UserRegisterDto;
import com.example.springbootmybatis.service.UserService;
import com.example.springbootmybatis.vo.UserDetailVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        // 模擬服務層行為
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        userRegisterDto.setEmail("test@example.com");
        userRegisterDto.setPassword("password123");

        when(userService.register(any(UserRegisterDto.class))).thenReturn(1);
        when(userService.getUserById(1)).thenReturn(mockUserDetailVo());

        // 執行測試
        ResponseEntity<UserDetailVo> response = userController.register(userRegisterDto);

        // 驗證結果
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("test@example.com", response.getBody().getEmail());

        // 驗證調用次數
        verify(userService, times(1)).register(any(UserRegisterDto.class));
        verify(userService, times(1)).getUserById(1);
    }

    @Test
    void testLogin() {
        // 模擬服務層行為
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setEmail("test@example.com");
        userLoginDto.setPassword("password123");

        when(userService.login(any(UserLoginDto.class))).thenReturn(mockUserDetailVo());

        // 執行測試
        ResponseEntity<UserDetailVo> response = userController.login(userLoginDto);

        // 驗證結果
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("test@example.com", response.getBody().getEmail());

        // 驗證調用次數
        verify(userService, times(1)).login(any(UserLoginDto.class));
    }

    private UserDetailVo mockUserDetailVo() {
        UserDetailVo userDetailVo = new UserDetailVo();
        userDetailVo.setUserId(1);
        userDetailVo.setEmail("test@example.com");
        return userDetailVo;
    }
}