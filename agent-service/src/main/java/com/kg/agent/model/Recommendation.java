package com.kg.agent.model;

import java.util.List;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    private List<KnowledgePoint> prerequisiteKnowledge;
    private List<KnowledgePoint> postrequisiteKnowledge;

    public Recommendation(String jsonStr) {

        JSONObject jsonObject = JSONUtil.parseObj(extractJson(jsonStr));
        
        // 获取前置知识点
        JSONArray prerequisiteKnowledgeJson = jsonObject.getJSONArray("prerequisite_knowledge");
        List<KnowledgePoint> prerequisiteKnowledge = JSONUtil.toList(prerequisiteKnowledgeJson, KnowledgePoint.class);

        // 获取后置知识点
        JSONArray postrequisiteKnowledgeJson = jsonObject.getJSONArray("postrequisite_knowledge");
        List<KnowledgePoint> postrequisiteKnowledge = JSONUtil.toList(postrequisiteKnowledgeJson, KnowledgePoint.class);

        // 创建 KnowledgeRecommendation 对象
        this.prerequisiteKnowledge = prerequisiteKnowledge;
        this.postrequisiteKnowledge = postrequisiteKnowledge;
    }

    private static String extractJson(String input) {
        int startIndex = input.indexOf("```json") + "```json".length();
        int endIndex = input.lastIndexOf("```");
        return input.substring(startIndex, endIndex).trim();
    }
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