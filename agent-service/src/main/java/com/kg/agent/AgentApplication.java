package com.kg.agent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 9:49 PM
 * @description Agent启动类
 */
@SpringBootApplication
@MapperScan("com.kg.agent.repository")
public class AgentApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }
}
