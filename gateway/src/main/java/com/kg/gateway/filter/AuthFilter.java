package com.kg.gateway.filter;

import com.kg.common.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import com.kg.gateway.config.AuthConfig;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;

/**
 * @author ggstudy11
 * @date Created in 2025/4/25 10:23
 * @description 登录鉴权过滤器
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AuthFilter implements GlobalFilter, Ordered {

    private final AuthConfig authConfig;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求头
        ServerHttpRequest request = exchange.getRequest();

        // 获取ip地址
        if (request.getRemoteAddress() != null) {
            String ip = request.getRemoteAddress().getAddress().getHostAddress();
            log.info("请求ip: {}, 接口路径: {}", ip, request.getPath());
        }

        // 放行路径
        if (isExclude(request.getPath().toString())) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("Authorization");
        if (!JwtUtil.validateToken(token)) {
            ServerHttpResponse response = exchange.getResponse();
            response.setRawStatusCode(401);
            return response.setComplete();
        }
        Map<String, Object> claims = JwtUtil.parseToken(token);
        String userInfo = claims.get("userId").toString();
        ServerWebExchange swx = exchange.mutate()
                .request(b ->b.header("user-info", userInfo))
                .build();
        return chain.filter(swx);
    }

    /**
     * @Description  是否放行路径
     * @param antPath -放行路径
     * @return
     * @Author ggstudy11
     * @Date
     */
    private boolean isExclude(String antPath) {
        for (String pathPattern : authConfig.getExcludePaths()) {
            if (antPathMatcher.match(pathPattern, antPath)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
