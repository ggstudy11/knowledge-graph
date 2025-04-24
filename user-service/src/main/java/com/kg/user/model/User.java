package com.kg.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 13:57
 * @description 用户实体类
 */
@Data
@Builder
@Schema(description = "用户信息")
@TableName("user")
public class User {
    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "md5加密盐值")
    private String salt;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "性别")
    private Integer gender;

    @Schema(description = "头像地址")
    private String avatar;
}
