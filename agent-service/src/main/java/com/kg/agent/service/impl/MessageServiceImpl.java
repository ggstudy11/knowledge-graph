package com.kg.agent.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.agent.model.Message;
import com.kg.agent.model.Recommendation;
import com.kg.agent.model.vo.MessageVO;
import com.kg.agent.repository.MessageMapper;
import com.kg.agent.service.IMessageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService{

    private final ChatClient chatClient;

    @Override
    public Recommendation send(String question, Integer id) {
        Message q = new Message();
        q.setContent(question);
        q.setConversationId(id);
        q.setRole("user");
        q.setCreateTime(LocalDateTime.now());
        this.save(q);

        String content = chatClient.prompt().user(question).call().content();
        Message a = new Message();
        a.setContent(content);
        a.setConversationId(id);
        a.setRole("assistant");
        a.setCreateTime(LocalDateTime.now());
        this.save(a);

        return new Recommendation(content);
    }

    @Override
    public List<MessageVO> listByConversationId(Integer id) {
        List<MessageVO> messageVOs = new ArrayList<>();
        this.lambdaQuery().eq(Message::getConversationId, id).orderByAsc(Message::getCreateTime).list().stream().forEach(message -> {
            MessageVO vo = new MessageVO();
            vo.setContent(message.getContent());
            vo.setRole(message.getRole());
            vo.setId(id);
            if (message.getRole().equals("assistant")) {
                vo.setRecommendation(new Recommendation(message.getContent()));
            }
            messageVOs.add(vo);
        });
        return messageVOs;
    }

}
