package com.kg.agent.model.vo;

import com.kg.agent.model.Recommendation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "消息VO")
public class MessageVO {
    @Schema(description = "消息ID")
    private Integer id;

    @Schema(description = "消息内容")
    private String content;

    @Schema(description = "角色")
    private String role;

    @Schema(description = "应答结果")
    private Recommendation recommendation;
}
