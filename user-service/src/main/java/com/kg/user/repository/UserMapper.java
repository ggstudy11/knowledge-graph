package com.kg.user.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kg.user.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ggstudy11
 * @date Created in 2025/4/24 14:05
 * @description 用户表访问类
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
