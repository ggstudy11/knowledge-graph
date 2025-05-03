package com.kg.agent.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.agent.model.Message;
import com.kg.agent.model.Recommendation;
import com.kg.agent.model.vo.MessageVO;

public interface IMessageService extends IService<Message>{

    Recommendation send(String question, Integer id);

    List<MessageVO> listByConversationId(Integer id);

}
