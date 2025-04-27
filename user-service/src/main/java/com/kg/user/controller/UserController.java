package com.kg.user.controller;

import com.kg.common.R;
import com.kg.common.UserContext;
import com.kg.user.model.dto.LoginDTO;
import com.kg.user.model.dto.RegisterDTO;
import com.kg.user.model.dto.UpdatePasswordDTO;
import com.kg.user.model.dto.UpdateUserInfoDTO;
import com.kg.user.model.vo.LoginVO;
import com.kg.user.model.vo.UserInfoVO;
import com.kg.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 4:22 PM
 * @description 用户管理接口
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "用户管理接口", description = "提供用户相关的操作接口")
public class UserController {

    private final IUserService userService;

    /** 用户登录
    * @param
    * @return
    * @author ggstudy11
    */
    @GetMapping("/login")
    @Operation(summary = "用户登录", description = "用户通过手机号和密码登录")
    public R<LoginVO> login(@Valid LoginDTO loginDTO) {
        return R.success(userService.login(loginDTO));
    }

    /** 用户注册
    * @param
    * @return
    * @author ggstudy11
    */
    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "用户通过手机号和密码注册")
    public R<Object> register(@Valid @RequestBody RegisterDTO registerDTO) {
        userService.register(registerDTO);
        return R.success();
    }

    /** 修改用户信息
    * @param
    * @return
    * @author ggstudy11
    */
    @PutMapping()
    @Operation(summary = "修改用户信息", description = "修改用户用户名和头像")
    public R<Object> updateInfo(@RequestBody UpdateUserInfoDTO updateUserInfoDTO) {
        userService.updateInfo(updateUserInfoDTO, UserContext.getUser());
        return R.success();
    }

    /** 获取用户信息
    * @param
    * @return
    * @author ggstudy11
    */
    @GetMapping()
    @Operation(summary = "获取用户信息", description = "获取用户相关信息")
    public R<UserInfoVO> get() {
        return R.success(userService.getInfo(UserContext.getUser()));
    }

    /** 找回密码
    * @param
    * @return
    * @author ggstudy11
    */
    @PutMapping("/password")
    @Operation(summary = "找回密码", description = "根据手机号和修改后的密码，修改密码")
    public R<Object> updatePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        userService.updatePassword(updatePasswordDTO);
        return R.success();
    }
}
