package com.kg.file.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 13:03
 * @description 分页查询
 */
@Data
@ToString
@Schema(description = "分页查询数据模型")
@NoArgsConstructor
public class FileFolderVO {
    @Schema(description = "id")
    private Integer id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "类型 0-md文件 1-知识图谱")
    private Integer type;

    @Schema(description = "是否为文件夹")
    private Integer isFolder;

    @Schema(description = "最后一次修改时间")
    private LocalDateTime lastTime;
}
