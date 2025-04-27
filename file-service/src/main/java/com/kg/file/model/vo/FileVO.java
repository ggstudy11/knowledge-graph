package com.kg.file.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:45
 * @description
 */
@Schema(description = "文件的数据模型")
@Builder
@ToString
@Data
public class FileVO {
    @Schema(description = "文件id")
    private Integer fileId;

    @Schema(description = "文件名称")
    private String fileName;

    @Schema(description = "文件类型")
    private Integer fileType;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
