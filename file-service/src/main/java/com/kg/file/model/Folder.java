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
 * @date Created in 2025/4/28 13:42
 * @description
 */
@Schema(description = "文件夹实体类")
@Data
@TableName(value = "folder")
@Builder
@ToString
public class Folder {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "文件夹名")
    private String name;

    @Schema(description = "父文件夹id")
    private Integer parentId;

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
