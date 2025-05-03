package com.kg.agent.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 9:50 PM
 * @description swagger配置类
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPi() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI agent微服务API文档")
                        .description("AI 微服务API文档, 主要实现agent问答等相关操作")
                        .version("1.0.0"));
    }
}
