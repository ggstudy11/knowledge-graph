package com.kg.user.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/26 13:27
 * @description 找回密码数据模型
 */
@Schema(description = "找回密码数据模型")
@Data
@ToString
public class UpdatePasswordDTO {

    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "修改后密码")
    private String password;
}
