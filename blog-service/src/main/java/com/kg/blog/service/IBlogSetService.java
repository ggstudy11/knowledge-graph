package com.kg.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kg.blog.model.BlogSet;

/**
 * @author ggstudy11
 * @date Created in 2025/4/30 16:33
 * @description
 */
public interface IBlogSetService extends IService<BlogSet> {
    BlogSet getSet();

    void updateSet(BlogSet blogSet);
}
