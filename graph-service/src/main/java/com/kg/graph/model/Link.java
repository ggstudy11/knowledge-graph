package com.kg.graph.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


/**
 * @author ggstudy11
 * @date Created in 2025/5/1 13:17
 * @description
 */
@Data
@Node
public class Link {

    @Id
    @GeneratedValue
    private Long id;

    private Integer graphId;
    private Long    node1;
    private Long    node2;
}
