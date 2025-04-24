package com.kg.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.common.utils.JwtUtil;
import com.kg.user.model.User;
import com.kg.user.model.dto.LoginDTO;
import com.kg.user.model.dto.RegisterDTO;
import com.kg.user.model.vo.LoginVO;
import com.kg.user.repository.UserMapper;
import com.kg.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 14:18
 * @description 实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        String phone = loginDTO.getPhone();
        String password = loginDTO.getPassword();

        /* 获取盐值 */
        User user = this.getOne(new QueryWrapper<User>().lambda().eq(User::getPhone, phone));
        String salt = user.getSalt();

        String saltPassword = password + salt;
        String passwordInMd5 = DigestUtils.md5DigestAsHex(saltPassword.getBytes());

        if (!passwordInMd5.equals(user.getPassword())) {
            /* some*/
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        String token = JwtUtil.generateToken(claims, "kg");

        return LoginVO.builder()
                .userId(user.getId())
                .avatar(user.getAvatar())
                .username(user.getUsername())
                .token(token)
                .build();
    }

    @Override
    public void register(RegisterDTO registerDTO) {
        String password = registerDTO.getPassword();
        String phone = registerDTO.getPhone();
        String username = registerDTO.getUsername();

        /* 随机一个salt值 */
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String salt = Base64.getEncoder().encodeToString(bytes);

        /* md5 加密 */
        String saltPassword = password + salt;
        String passwordInMd5 = DigestUtils.md5DigestAsHex(saltPassword.getBytes());

        User user = User.builder()
                .username(username)
                .password(passwordInMd5)
                .salt(salt)
                .phone(phone)
                .gender(0)
                .avatar("https://xxx.com")
                .build();

        this.save(user);
    }
}
