package com.kg.blog;

import cn.hutool.json.JSONUtil;
import com.kg.common.KnowledgePoints;
import com.kg.common.utils.CozeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ggstudy11
 * @date Created in 2025/4/30 14:38
 * @description CozeAPI测试
 */
@SpringBootTest
public class CozeTest {

    static final String URL = "https://blog.csdn.net/m0_69660072/article/details/147563114?spm=1001.2100.3001.7377&utm_medium=distribute.pc_feed_blog.none-task-blog-hot-2-147563114-null-null.nonecase&depth_1-utm_source=distribute.pc_feed_blog.none-task-blog-hot-2-147563114-null-null.nonecase";

    @Test public void chatTest() throws Exception {
        CozeUtil.chat("1", URL);
        System.out.println(JSONUtil.toJsonStr(CozeUtil.chat("1", URL)));
    }

    @Test public void jsonTest() {
        String json = "{\n" +
                "    \"knowledge_points\": [\n" +
                "        {\"point\":  \"Golang学习内容全解析\"},\n" +
                "        {\"point\": \"Golang : 变量与常量定义规则\"},\n" +
                "        {\"point\": \"Golang : 基本数据类型示例\"},\n" +
                "        {\"point\": \"Golang : 条件与循环的运用\"},\n" +
                "        {\"point\": \"Golang : 数组与切片的区别\"},\n" +
                "        {\"point\": \"Golang : map字典的操作\"},\n" +
                "        {\"point\": \"Golang : 函数定义与调用法\"},\n" +
                "        {\"point\": \"Golang : 多返回值错误处理\"},\n" +
                "        {\"point\": \"Golang : 指针使用示例讲解\"},\n" +
                "        {\"point\": \"Golang : 并发相关示例展示\"},\n" +
                "        {\"point\": \"Golang : go mod初始化方法\"},\n" +
                "        {\"point\": \"Golang : Gin框架安装使用\"},\n" +
                "        {\"point\": \"Golang : 适合高并发编程\"}\n" +
                "    ]\n" +
                "}";
        KnowledgePoints result = JSONUtil.toBean(json, KnowledgePoints.class);
        System.out.println(result);
    }
}
