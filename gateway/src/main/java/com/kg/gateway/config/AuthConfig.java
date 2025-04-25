package com.kg.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author ggstudy11
 * @date Created in 2025/4/25 10:21
 * @description 鉴权配置
 */
@Configuration
@ConfigurationProperties(prefix = "auth")
@Data
public class AuthConfig {
    List<String> excludePaths;
}