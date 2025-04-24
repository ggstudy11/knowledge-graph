package com.kg.user.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 15:34
 * @description 登录返回数据模型
 */
@Data
@Builder
@Schema(description = "登录返回数据模型")
@ToString
public class LoginVO {
    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "token")
    private String token;
}
