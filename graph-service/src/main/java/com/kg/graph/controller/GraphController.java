package com.kg.graph.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}")
    @Operation(summary = "创建节点", description = "创建一个知识节点")
    public void createNode() {

    }

    @PutMapping("/{graphId}/{nodeId}")
    @Operation(summary = "更新节点", description = "更新知识节点")
    public void updateNode() {

    }

    @DeleteMapping("/{graphId}/{nodeId}")
    @Operation(summary = "删除节点", description = "删除节点")
    public void deleteNode() {

    }

    @GetMapping("/{id}")
    @Operation(summary = "获取所有节点", description = "获取当前知识图谱的所有节点")
    public void getAllNodes() {

    }

    @GetMapping("/{graphId}/{nodeId}")
    @Operation(summary = "获取节点详情", description = "获取某个节点的详细信息")
    public void getNode() {

    }

    @GetMapping("/{id}/search")
    @Operation(summary = "按关键词搜索节点", description = "根据关键词模糊匹配节点")
    public void searchNode() {

    }

    @GetMapping("/{id}/relations")
    @Operation(summary = "获取所有关系", description = "获取所有节点之间的关系")
    public void getAllRelations() {

    }

    @PostMapping("/{id}/relations")
    @Operation(summary = "创建节点之间关系", description = "创建节点之间的关系")
    public void createRelation() {

    }

    @DeleteMapping("/{graphId}/relations/{relationId}")
    @Operation(summary = "删除节点关系", description = "删除节点关系")
    public void deleteRelation() {

    }
}
