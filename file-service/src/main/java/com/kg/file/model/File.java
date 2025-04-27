package com.kg.file.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/4/27 11:25
 * @description file实体类
 */
@Schema(description = "file实体类")
@Data
@Builder
@ToString
@TableName("file")
public class File {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "文件名")
    private String name;

    @Schema(description = "文件url, 如果是知识图谱则没有")
    private String url;

    @Schema(description = "文件类型 0-md文件 1-知识图谱")
    private Integer type;

    @Schema(description = "文件夹id")
    private Integer folderId;

    @Schema(description = "拥有者id")
    private Integer userId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    @Schema(description = "修改次数")
    private Integer revisions;
}
