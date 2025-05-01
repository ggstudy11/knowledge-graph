package com.kg.graph.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 12:45
 * @description 更新数据模型
 */
@Data
@ToString
@Schema(description = "Knowledge更新数据模型")
public class UpdateKnowledgeDTO {
    @NotNull(message = "名字不能为空")
    @Schema(description = "节点名字")
    private String name;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "关联文件id")
    private Integer fileId;

    @Schema(description = "博客url")
    private String blog;

    @Schema(description = "图谱id")
    private Integer graphId;
}