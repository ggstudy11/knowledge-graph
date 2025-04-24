package com.kg.file.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

/**
 * @author ggstudy11
 * @date Created in 4/16/2025 9:50 PM
 * @description swagger配置类
 */
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPi() {
        return new OpenAPI()
                .info(new Info()
                        .title("文件存储微服务API文档")
                        .description("文件存储微服务API文档, 主要实现文件存储等相关操作")
                        .version("1.0.0"));
    }
}
