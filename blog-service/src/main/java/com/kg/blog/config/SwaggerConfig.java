package com.kg.blog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 10:12 PM
 * @description swagger配置类
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPi() {
        return new OpenAPI()
                .info(new Info()
                        .title("博客监控微服务API文档")
                        .description("博客监控微服务API文档，API主要实现关键词提取等博客内容检测操作")
                        .version("1.0.0"));
    }
}
