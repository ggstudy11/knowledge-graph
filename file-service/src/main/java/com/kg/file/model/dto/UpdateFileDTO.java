package com.kg.file.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/28 13:28
 * @description
 */
@Data
@Builder
@ToString
@Schema(description = "修改文件数据模型")
public class UpdateFileDTO {

    @Schema(description = "新文件名")
    private String name;

    @Schema(description = "新文件夹id")
    private Integer folderId;
}
