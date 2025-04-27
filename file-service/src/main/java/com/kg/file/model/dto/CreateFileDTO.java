package com.kg.file.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:41
 * @description 创建文件的数据模型
 */
@Data
@ToString
@Schema(description = "创建文件的数据模型")
public class CreateFileDTO {

    @Schema(description = "文件名")
    @NotNull(message = "文件名不能为空")
    private String fileName;

    @Schema(description = "文件类型")
    @NotNull(message = "文件类型不能为空")
    private Integer fileType;

    @Schema(description = "文件夹")
    @NotNull(message = "文件夹不能为空")
    private Integer folderId;
}
