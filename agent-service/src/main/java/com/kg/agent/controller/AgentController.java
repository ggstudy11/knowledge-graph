package com.kg.agent.controller;

import com.kg.agent.model.Question;
import com.kg.agent.model.Title;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.coze.openapi.client.connversations.message.model.Message;
import com.kg.agent.model.Conversation;
import com.kg.agent.model.Recommendation;
import com.kg.agent.model.vo.MessageVO;
import com.kg.agent.service.IConversationService;
import com.kg.agent.service.IMessageService;
import com.kg.common.R;

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

    private final IConversationService conversationService;
    private final IMessageService messageService;
    
    @PostMapping("/{id}")
    @Operation(summary = "发送问题", description = "根据对应会话id发送问答")
    public R<Recommendation> sendQuest(@RequestBody Question question, @PathVariable(value = "id") Integer id) {
        log.info("发送问题：{}", question.getQuestion());
        return R.success(messageService.send(question.getQuestion(), id));
    }


    @GetMapping
    @Operation(summary = "获取历史对话列表", description = "获取用户所有的历史对话")
    public R<List<Conversation>> getConversations() {
        log.info("获取历史对话列表");
        return R.success(conversationService.listByUserId());
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取对话详情", description = "获取对话详细信息")
    public R<List<MessageVO>> getConversation(@PathVariable(value = "id") Integer id) {
        log.info("获取对话详情：{}", id);
        return R.success(messageService.listByConversationId(id));
    }

    @PostMapping()
    @Operation(summary = "创建对话", description = "创建新的对话")
    public R<Conversation> createConversation() {
        log.info("创建对话");
        return R.success(conversationService.create());
    }

    @PutMapping("/{id}")
    @Operation(summary = "对话重命名", description = "重命名某个id的会话")
    public R<LocalDateTime> updateConversation(@RequestBody Title title, @PathVariable(value = "id") Integer id) {
        log.info("对话重命名：{}", title.getTitle());
        return R.success(conversationService.updateTile(title.getTitle(), id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除会话", description = "删除某个id会话")
    public R<Object> deleteConversation(@PathVariable(value = "id") Integer id) {
        log.info("删除会话：{}", id);
        conversationService.removeById(id);
        return R.success();
    }
}
