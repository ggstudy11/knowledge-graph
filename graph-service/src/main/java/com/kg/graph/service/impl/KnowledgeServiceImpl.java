package com.kg.graph.service.impl;

import com.kg.common.UserContext;
import com.kg.graph.model.Knowledge;
import com.kg.graph.model.KnowledgeDTO;
import com.kg.graph.repository.KnowledgeRepository;
import com.kg.graph.service.KnowledgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 10:00
 * @description
 */
@Service
@RequiredArgsConstructor
public class KnowledgeServiceImpl implements KnowledgeService {

    private final KnowledgeRepository knowledgeRepository;

    @Override
    public Knowledge create(KnowledgeDTO knowledgeDTO, Integer id) {
        Knowledge knowledge = new Knowledge();
        knowledge.setName(knowledgeDTO.getName());
        knowledge.setDescription(knowledgeDTO.getDescription());
        knowledge.setGraphId(id);
        knowledge.setUserId(UserContext.getUser());
        knowledge.setFileId(knowledgeDTO.getFileId());
        knowledge.setCreateTime(LocalDateTime.now());
        knowledge.setUpdateTime(LocalDateTime.now());
        knowledge.setBlog(knowledgeDTO.getBlog());
        knowledgeRepository.save(knowledge);
        return knowledge;
    }

    @Override
    public Knowledge getNode(String id) {
        return knowledgeRepository.findById(id).orElse(null);
    }
}
