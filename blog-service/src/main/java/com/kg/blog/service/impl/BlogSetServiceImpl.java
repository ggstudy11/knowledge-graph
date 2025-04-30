package com.kg.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kg.blog.model.BlogSet;
import com.kg.blog.repository.BlogSetMapper;
import com.kg.blog.service.IBlogSetService;
import com.kg.common.UserContext;
import org.springframework.stereotype.Service;

/**
 * @author ggstudy11
 * @date Created in 2025/4/30 16:34
 * @description
 */
@Service
public class BlogSetServiceImpl extends ServiceImpl<BlogSetMapper, BlogSet> implements IBlogSetService {
    @Override
    public BlogSet getSet() {
        BlogSet set = this.getOne(new QueryWrapper<BlogSet>().lambda().eq(BlogSet::getUserId, UserContext.getUser()));
        if (set == null) {
            set = new BlogSet();
            set.setUserId(UserContext.getUser());
            set.setAutoMonitor(0);
            set.setAutoNode(0);
            this.save(set);
        }
        return set;
    }

    @Override
    public void updateSet(BlogSet blogSet) {
        BlogSet set = this.getSet();
        set.setAutoNode(blogSet.getAutoNode());
        set.setAutoMonitor(blogSet.getAutoMonitor());
        this.updateById(set);
    }
}
