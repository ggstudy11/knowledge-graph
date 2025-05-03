package com.kg.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.common.BusinessException;
import com.kg.common.UserContext;
import com.kg.common.utils.JwtUtil;
import com.kg.user.model.User;
import com.kg.user.model.dto.LoginDTO;
import com.kg.user.model.dto.RegisterDTO;
import com.kg.user.model.dto.UpdatePasswordDTO;
import com.kg.user.model.dto.UpdateUserInfoDTO;
import com.kg.user.model.vo.LoginVO;
import com.kg.user.model.vo.UserInfoVO;
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

        
        User user = this.getOne(new QueryWrapper<User>().lambda().eq(User::getPhone, phone));
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        /* 获取盐值 */
        String salt = user.getSalt();

        String saltPassword = password + salt;
        String passwordInMd5 = DigestUtils.md5DigestAsHex(saltPassword.getBytes());

        if (!passwordInMd5.equals(user.getPassword())) {
            throw new BusinessException("密码错误");
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

        /* 检查手机号是否已经被注册 */
        User existUser = this.getOne(new QueryWrapper<User>().lambda().eq(User::getPhone, phone));
        if (existUser != null) {
            /* 用户已存在 */
            throw new BusinessException("手机号已被注册");
        }

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
                .avatar("https://knowgraph-bucket.oss-cn-shanghai.aliyuncs.com/6c1b584dad9add524a102a230fb8e1fe.jpg")
                .build();

        this.save(user);
    }

    @Override
    public UserInfoVO getInfo(Integer id) {
        User user = getById(id);
        return UserInfoVO.builder()
                .username(user.getUsername())
                .phone(user.getPhone())
                .gender(user.getGender())
                .avatar(user.getAvatar())
                .build();
    }

    @Override
    public void updatePassword(UpdatePasswordDTO updatePasswordDTO) {
        String password = updatePasswordDTO.getPassword();
        String phone = updatePasswordDTO.getPhone();

        User user = this.getOne(new QueryWrapper<User>().lambda().eq(User::getPhone, phone));
        /* 用户不存在 */
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        String salt = user.getSalt();
        String newPassword = salt + password;
        String newPasswordInMD5 = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        user.setPassword(newPasswordInMD5);

        this.updateById(user);
    }

    @Override
    public void updateInfo(UpdateUserInfoDTO updateUserInfoDTO) {
        User user = getById(UserContext.getUser());
        if (updateUserInfoDTO.getAvatar() != null) {
            user.setAvatar(updateUserInfoDTO.getAvatar());
        }
        if (updateUserInfoDTO.getUsername()!= null) {
            user.setUsername(updateUserInfoDTO.getUsername());
        }
        this.updateById(user);
    }
}
