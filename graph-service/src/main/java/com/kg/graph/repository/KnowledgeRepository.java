package com.kg.graph.repository;

import com.kg.graph.model.Knowledge;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 9:56
 * @description 访问类
 */
public interface KnowledgeRepository extends Neo4jRepository<Knowledge, String> {
}
