package com.kg.agent.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 9:53 PM
 * @description 大模型问答接口
 */
@RestController
@RequestMapping("/api/agent")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "agent问答接口", description = "主要实现大模型问答等相关接口管理")
public class AgentController {

    @PostMapping("/{id}")
    @Operation(summary = "发送问题", description = "根据对应会话id发送问答")
    public void sendQuest() {
        
    }

    @PutMapping("/{id}/intention")
    @Operation(summary = "切换意图", description = "切换对应对话id的意图")
    public void updateIntention() {

    }

    @GetMapping()
    @Operation(summary = "获取历史对话列表", description = "获取用户所有的历史对话")
    public void getConversations() {

    }

    @GetMapping("/{id}")
    @Operation(summary = "获取对话详情", description = "获取对话详细信息")
    public void getConversation() {

    }

    @PostMapping()
    @Operation(summary = "创建对话", description = "创建新的对话")
    public void createConversation() {

    }

    @PutMapping("/{id}")
    @Operation(summary = "对话重命名", description = "重命名某个id的会话")
    public void updateConversation() {

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除会话", description = "删除某个id会话")
    public void deleteConversation() {

    }
}
