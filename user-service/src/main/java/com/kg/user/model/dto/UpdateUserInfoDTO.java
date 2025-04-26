package com.kg.user.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/26 13:53
 * @description 更新用户信息的数据模型
 */
@Data
@ToString
@Schema(description = "更新用户信息的数据模型")
public class UpdateUserInfoDTO {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "头像地址")
    private String avatar;
}
