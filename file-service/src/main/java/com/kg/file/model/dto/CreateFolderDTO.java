package com.kg.file.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/28 13:52
 * @description
 */
@Schema(description = "创建文件数据模型")
@Data
@ToString
@Builder
public class CreateFolderDTO {

    @Schema(description = "文件夹名")
    @NotNull(message = "文件夹名不能为空")
    private String name;

    @Schema(description = "父文件夹id")
    @NotNull(message = "父文件夹id不能为空")
    private Integer folderId;
}
