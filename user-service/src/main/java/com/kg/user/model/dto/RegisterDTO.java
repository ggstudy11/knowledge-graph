package com.kg.user.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 14:58
 * @description
 */
@Schema(description = "注册数据模型")
@Data
public class RegisterDTO {

    @Schema(description = "电话号", example = "15669893275")
    @NotNull(message = "电话号不能为空")
    @Size(min = 11, max = 11, message = "电话号必须是11位")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "电话号必须是有效的中国手机号")
    private String phone;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;
}
