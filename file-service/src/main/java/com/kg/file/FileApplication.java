package com.kg.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 10:56 PM
 * @description 文件存储微服务
 */
@SpringBootApplication
@MapperScan("com.kg.file.repository")
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }
}
