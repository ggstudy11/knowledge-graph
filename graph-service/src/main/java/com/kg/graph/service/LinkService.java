package com.kg.graph.service;

import com.kg.graph.model.Link;
import com.kg.graph.model.dto.LinkDTO;

import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 13:30
 * @description
 */
public interface LinkService {
    Long create(LinkDTO linkDTO, Integer id);

    void delete(Long id);

    List<Link> getAll(Integer id);
}
