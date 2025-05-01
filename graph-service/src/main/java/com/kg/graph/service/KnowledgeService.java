package com.kg.graph.service;

import com.kg.graph.model.Knowledge;
import com.kg.graph.model.KnowledgeDTO;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 9:59
 * @description
 */
public interface KnowledgeService {
    Knowledge create(KnowledgeDTO knowledgeDTO, Integer id);

    Knowledge getNode(String nodeId);
}
