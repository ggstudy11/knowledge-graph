package com.kg.graph.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 9:06
 * @description 知识图谱节点
 */

@Node
@Schema(description = "知识图谱节点类")
@Data
public class Knowledge {

    @Id
    @GeneratedValue
    @Schema(description = "主键")
    private Long id;


    @Schema(description = "对应知识图谱id")
    private Integer graphId;

    @Schema(description = "节点名字")
    private String name;

    @Schema(description = "节点描述")
    private String description;

    @Schema(description = "关联的文件名")
    private String fileName;

    @Schema(description = "绑定的文件id")
    private Integer fileId;

    @Schema(description = "博客url")
    private String  blogUrl;

    @Schema(description = "博客标题")
    private String blogTitle;

    @Schema(description = "节点大小")
    private Integer size;

    @Schema(description = "节点颜色")
    private String color;
    
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "修改时间")
    private LocalDateTime updateTime;
}
