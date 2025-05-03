package com.kg.agent.repository;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kg.agent.model.Message;

@Mapper
public interface MessageMapper extends BaseMapper<Message>{

    
} 