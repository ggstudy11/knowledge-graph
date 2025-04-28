package com.kg.file.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/28 14:05
 * @description
 */
@Schema(description = "更新文件夹数据模型")
@Data
@ToString
@Builder
public class UpdateFolderDTO {
    private Integer folderId;
    private String folderName;
}
