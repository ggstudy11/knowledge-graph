package com.kg.agent.service;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.agent.model.Conversation;

public interface IConversationService extends IService<Conversation>{

    Conversation create();

    LocalDateTime updateTile(String title, Integer id);

    List<Conversation> listByUserId();

}
