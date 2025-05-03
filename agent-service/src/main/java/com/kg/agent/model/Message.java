package com.kg.agent.model;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@TableName(value = "message")
@Schema(description = "消息表")
public class Message {

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description = "主键ID")
    private Integer id;

    @Schema(description = "会话ID")
    private Integer conversationId;

    @Schema(description = "消息内容")
    private String content;

    @Schema(description = "角色")
    private String role;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}
