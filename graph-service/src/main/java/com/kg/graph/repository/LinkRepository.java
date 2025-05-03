package com.kg.graph.repository;

import com.kg.graph.model.Link;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 13:29
 * @description
 */
public interface LinkRepository extends Neo4jRepository<Link, Long> {

    @Query("MATCH (e:Link) WHERE e.node1 = $nodeId OR e.node2 = $nodeId RETURN ID(e)")
    List<Long> getIds(@Param("nodeId") Long nodeId);
}
