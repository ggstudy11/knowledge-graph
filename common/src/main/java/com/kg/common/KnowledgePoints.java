package com.kg.common;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 2025/4/30 15:52
 * @description
 */
@ToString
@Data
public class KnowledgePoints {
    List<Point> knowledge_points = new ArrayList<>();
}

@Data
@ToString
class Point {
     private String point;
}
