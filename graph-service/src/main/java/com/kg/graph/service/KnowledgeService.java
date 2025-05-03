package com.kg.graph.service;

import com.kg.graph.model.Knowledge;
import com.kg.graph.model.dto.KnowledgeDTO;
import com.kg.graph.model.dto.UpdateKnowledgeDTO;

import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 9:59
 * @description
 */
public interface KnowledgeService {
    Knowledge create(KnowledgeDTO knowledgeDTO, Integer id);

    Knowledge get(Long id);

    List<Long> delete(Long id);

    Knowledge update(UpdateKnowledgeDTO updateknowledgeDTO, Long id);

    List<Knowledge> getAll(Integer id);

    List<Knowledge> search(String keyword);
}
