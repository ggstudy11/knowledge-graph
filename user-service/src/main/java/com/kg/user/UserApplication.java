package com.kg.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 4:10 PM
 * @description 用户微服务启动类
 */

@SpringBootApplication
@MapperScan("com.kg.user.repository")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
