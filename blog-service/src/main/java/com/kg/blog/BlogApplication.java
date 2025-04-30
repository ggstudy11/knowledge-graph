package com.kg.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 10:10 PM
 * @description 博客微服务启动类
 */
@SpringBootApplication
@MapperScan("com.kg.blog.repository")
public class BlogApplication {
    public static void main(String[] args){
        SpringApplication.run(BlogApplication.class, args);
    }
}
