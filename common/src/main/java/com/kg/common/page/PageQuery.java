package com.kg.common.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageQuery {

    private Integer pageNo;
    private Integer pageSize;

    public <T> Page<T> toMpPage(OrderItem... orders) {
        // 1.分页条件
        Page<T> p = Page.of(pageNo, pageSize);
        // 2.排序条件
        if (orders != null) {
            p.addOrder(orders);
        }
        return p;
    }

}