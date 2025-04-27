package com.kg.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.user.model.User;
import com.kg.user.model.dto.LoginDTO;
import com.kg.user.model.dto.RegisterDTO;
import com.kg.user.model.dto.UpdatePasswordDTO;
import com.kg.user.model.dto.UpdateUserInfoDTO;
import com.kg.user.model.vo.LoginVO;
import com.kg.user.model.vo.UserInfoVO;
import jakarta.validation.Valid;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 14:17
 * @description
 */
public interface IUserService extends IService<User> {
    LoginVO login(@Valid LoginDTO loginDTO);

    void register(@Valid RegisterDTO registerDTO);

    UserInfoVO getInfo(Integer id);

    void updatePassword(UpdatePasswordDTO updatePasswordDTO);

    void updateInfo(UpdateUserInfoDTO updateUserInfoDTO, Integer id);
}
