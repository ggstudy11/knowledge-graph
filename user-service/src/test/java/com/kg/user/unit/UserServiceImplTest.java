package com.kg.user.unit;

import com.kg.common.UserContext;
import com.kg.user.model.dto.LoginDTO;
import com.kg.user.model.dto.RegisterDTO;
import com.kg.user.model.vo.LoginVO;
import com.kg.user.model.vo.UserInfoVO;
import com.kg.user.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 16:16
 * @description 测试用户
 */
// @SpringBootTest
//public class UserServiceImplTest {
//
//    private IUserService userService;
//
//
//    @Test public void registerTest() {
//        RegisterDTO registerDTO = new RegisterDTO();
//        registerDTO.setUsername("测试用户1");
//        registerDTO.setPassword("test123456");
//        registerDTO.setPhone("15669893275");
//        userService.register(registerDTO);
//    }
//
//    @Test public void loginTest() {
//        LoginDTO loginDTO = new LoginDTO();
//        loginDTO.setPassword("123456");
//        loginDTO.setPhone("15669893275");
//        LoginVO loginVO = userService.login(loginDTO);
//        System.out.println(loginVO);
//    }
//
//    @Test public void getUserInfoTest() {
//        UserInfoVO userInfoVO = userService.getInfo(1);
//        System.out.println(userInfoVO);
//    }
//
//}
