package com.kg.graph.repository;

import com.kg.graph.model.Knowledge;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 9:56
 * @description 访问类
 */
public interface KnowledgeRepository extends Neo4jRepository<Knowledge, Long> {

    @Query("MATCH (e:Knowledge) WHERE e.name CONTAINS $keyword OR e.description CONTAINS $keyword RETURN e")
    List<Knowledge> search(@Param("keyword") String keyword);
}
