package com.kg.agent.repository;


import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kg.agent.model.Conversation;

@Mapper
public interface ConversationMapper extends BaseMapper<Conversation>{
 
} 