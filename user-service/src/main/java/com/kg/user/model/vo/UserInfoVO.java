package com.kg.user.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/26 12:55
 * @description 用户信息数据模型
 */
@Schema(description = "用户信息数据模型")
@Data
@Builder
@ToString
public class UserInfoVO {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "性别 0为男 1为女")
    private Integer gender;

    @Schema(description = "头像")
    private String avatar;
}
