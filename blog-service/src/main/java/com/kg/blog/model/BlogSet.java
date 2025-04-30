package com.kg.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * @author ggstudy11
 * @date Created in 2025/4/30 16:25
 * @description 博客设置实体类
 */
@Schema(description = "博客设置实体类")
@ToString
@Data
@TableName(value = "blog_set")
public class BlogSet {
    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;

    @Schema(description = "是否自动监督")
    private Integer autoMonitor;

    @Schema(description = "是否自动创建节点")
    private Integer autoNode;
}
