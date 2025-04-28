package com.kg.file.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/28 13:41
 * @description
 */
@Schema(description = "文件夹数据模型")
@ToString
@Builder
@Data
public class FolderVO {

    private Integer id;

    @Schema(description = "文件夹名")
    private String name;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
