package com.kg.graph.service.impl;

import com.kg.graph.model.Knowledge;
import com.kg.graph.model.dto.KnowledgeDTO;
import com.kg.graph.model.dto.UpdateKnowledgeDTO;
import com.kg.graph.repository.KnowledgeRepository;
import com.kg.graph.service.KnowledgeService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        knowledge.setFileId(knowledgeDTO.getFileId());
        knowledge.setCreateTime(LocalDateTime.now());
        knowledge.setUpdateTime(LocalDateTime.now());
        knowledge.setBlog(knowledgeDTO.getBlog());
        knowledgeRepository.save(knowledge);
        return knowledge;
    }

    @Override
    public Knowledge get(Long id) {
        return knowledgeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        knowledgeRepository.deleteById(id);
    }

    @Override
    public Knowledge update(UpdateKnowledgeDTO updateKnowledgeDTO, Long id) {
        Knowledge knowledge = knowledgeRepository.findById(id).orElse(null);
        knowledge.setName(updateKnowledgeDTO.getName());
        knowledge.setDescription(updateKnowledgeDTO.getDescription());
        knowledge.setGraphId(updateKnowledgeDTO.getGraphId());
        knowledge.setFileId(updateKnowledgeDTO.getFileId());
        knowledge.setUpdateTime(LocalDateTime.now());
        knowledge.setBlog(updateKnowledgeDTO.getBlog());
        knowledgeRepository.save(knowledge);
        return knowledge;
    }

    @Override
    public List<Knowledge> getAll(Integer id) {
        return knowledgeRepository.findAll(new Example<>() {
            @NotNull
            @Override
            public Knowledge getProbe() {
                Knowledge knowledge = new Knowledge();
                knowledge.setGraphId(id);
                return knowledge;
            }

            @NotNull
            @Override
            public ExampleMatcher getMatcher() {
                return ExampleMatcher.matching()
                        .withMatcher("graphId", ExampleMatcher.GenericPropertyMatchers.exact());
            }
        });
    }

    @Override
    public List<Knowledge> search(String keyword) {
        return knowledgeRepository.search(keyword);
    }
}
