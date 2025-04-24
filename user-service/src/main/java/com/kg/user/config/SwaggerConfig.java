package com.kg.user.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 4:17 PM
 * @description Swagger配置
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPi() {
        return new OpenAPI()
                .info(new Info()
                        .title("用户微服务API文档")
                        .description("用户微服务API文档，API主要实现用户的管理功能")
                        .version("1.0.0"));
    }
}
