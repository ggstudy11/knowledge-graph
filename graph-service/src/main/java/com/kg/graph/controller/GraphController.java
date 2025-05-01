package com.kg.graph.controller;


import com.kg.common.R;
import com.kg.graph.model.Knowledge;
import com.kg.graph.model.Link;
import com.kg.graph.model.dto.KnowledgeDTO;
import com.kg.graph.model.dto.LinkDTO;
import com.kg.graph.model.dto.UpdateKnowledgeDTO;
import com.kg.graph.service.KnowledgeService;
import com.kg.graph.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 10:29 PM
 * @description 知识图谱控制类
 */
@RestController
@RequestMapping("/api/graph")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "知识图谱接口", description = "知识图谱相关操作控制器")
public class GraphController {

    private final KnowledgeService knowledgeService;
    private final LinkService linkService;

    @PostMapping("/{id}/node")
    @Operation(summary = "创建节点", description = "创建一个知识节点")
    public R<Knowledge> createNode(@PathVariable(value = "id") Integer id, @RequestBody KnowledgeDTO knowledgeDTO) {
        return R.success(knowledgeService.create(knowledgeDTO, id));
    }

    @PutMapping("/node/{id}")
    @Operation(summary = "更新节点", description = "更新知识节点")
    public R<Knowledge> updateNode(@PathVariable(value = "id") Long id, @RequestBody UpdateKnowledgeDTO updateKnowledgeDTO) {
        return R.success(knowledgeService.update(updateKnowledgeDTO, id));
    }

    @DeleteMapping("/node/{id}")
    @Operation(summary = "删除节点", description = "删除节点")
    public R<Object> deleteNode(@PathVariable(value = "id") Long id) {
        knowledgeService.delete(id);
        return R.success();
    }

    @GetMapping("/{id}/node")
    @Operation(summary = "获取所有节点", description = "获取id知识图谱的所有节点")
    public R<List<Knowledge>> getAllNodes(@PathVariable(value = "id") Integer id) {
        return R.success(knowledgeService.getAll(id));
    }

    @GetMapping("/node/{id}")
    @Operation(summary = "获取节点详情", description = "获取某个节点的详细信息")
    public R<Knowledge> getNode(@PathVariable(value = "id") Long id) {
        return R.success(knowledgeService.get(id));
    }

    @GetMapping("/search")
    @Operation(summary = "按关键词搜索节点", description = "根据关键词模糊匹配节点")
    public R<List<Knowledge>> searchNode(@RequestParam("keyword") String keyword) {
        return R.success(knowledgeService.search(keyword));
    }

    @GetMapping("/{id}/relation")
    @Operation(summary = "获取所有关系", description = "获取所有节点之间的关系")
    public R<List<Link>> getAllRelations(@PathVariable(value = "id") Integer id) {
        return R.success(linkService.getAll(id));
    }

    @PostMapping("/{id}/relation")
    @Operation(summary = "创建节点之间关系", description = "创建节点之间的关系")
    public R<Long> createRelation(@PathVariable(value = "id") Integer id, @RequestBody LinkDTO linkDTO) {
        return R.success(linkService.create(linkDTO, id));
    }

    @DeleteMapping("/relation/{id}")
    @Operation(summary = "删除节点关系", description = "删除节点关系")
    public R<Object> deleteRelation(@PathVariable(value = "id") Long id) {
        linkService.delete(id);
        return R.success();
    }
}
