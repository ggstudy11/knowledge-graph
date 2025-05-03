package com.kg.common;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Recommendation {
    private List<KnowledgePoint> prerequisiteKnowledge;
    private List<KnowledgePoint> postrequisiteKnowledge;
}


/*
 * @author ggstudy11
 * @date Created in 2025/5/1 12:45
 * @description 知识点模型
 */
@Data
@ToString
class KnowledgePoint {
    private String point;
    private String reason;
}