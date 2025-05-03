package com.kg.agent.model;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 9:49 PM
 * @description 会话实体类
 */
@Schema(description = "会话实体类")
@Data
@TableName(value = "conversation")
public class Conversation {

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键")
    private Integer id;

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "会话标题")
    private String title;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
