package com.kg.graph.service.impl;

import com.kg.graph.model.Link;
import com.kg.graph.model.dto.LinkDTO;
import com.kg.graph.repository.LinkRepository;
import com.kg.graph.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 2025/5/1 13:30
 * @description
 */
@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    @Override
    public Long create(LinkDTO linkDTO, Integer id) {
        Link link = new Link();
        link.setGraphId(id);
        link.setNode1(linkDTO.getNode1());
        link.setNode2(linkDTO.getNode2());
        linkRepository.save(link);
        return link.getId();
    }

    @Override
    public void delete(Long id) {
        linkRepository.deleteById(id);
    }

    @Override
    public List<Link> getAll(Integer id) {
        return linkRepository.findAll(new Example<>() {
            @NotNull
            @Override
            public Link getProbe() {
                Link link = new Link();
                link.setGraphId(id);
                return link;
            }

            @NotNull
            @Override
            public ExampleMatcher getMatcher() {
                return ExampleMatcher.matching()
                        .withMatcher("graphId", ExampleMatcher.GenericPropertyMatchers.exact());
            }
        });
    }
}
