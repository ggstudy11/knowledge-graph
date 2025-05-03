package com.kg.agent.service.impl;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.agent.model.Conversation;
import com.kg.agent.repository.ConversationMapper;
import com.kg.agent.service.IConversationService;
import com.kg.common.UserContext;

@Service
public class ConversationServiceImpl extends ServiceImpl<ConversationMapper, Conversation> implements IConversationService{

    @Override
    public Conversation create() {
        Conversation conversation = new Conversation();
        conversation.setTitle("新对话");
        conversation.setCreateTime(LocalDateTime.now());
        conversation.setUpdateTime(LocalDateTime.now());
        conversation.setUserId(UserContext.getUser());
        this.save(conversation);
        return conversation;
    }

    @Override
    public LocalDateTime updateTile(String title, Integer id) {
        Conversation conv = this.getById(id);
        conv.setTitle(title);
        conv.setUpdateTime(LocalDateTime.now());
        this.updateById(conv);
        return conv.getUpdateTime();
    }

    @Override
    public List<Conversation> listByUserId() {
        return this.lambdaQuery()
                .eq(Conversation::getUserId, UserContext.getUser())
                .orderByDesc(Conversation::getUpdateTime)
                .list();
    }
}
