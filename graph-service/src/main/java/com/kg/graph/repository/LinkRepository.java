package com.kg.graph.repository;

import com.kg.graph.model.Link;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 13:29
 * @description
 */
public interface LinkRepository extends Neo4jRepository<Link, Long> {
}
