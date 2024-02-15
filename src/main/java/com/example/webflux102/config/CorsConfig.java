package com.example.webflux102.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        return new CorsWebFilter((ServerWebExchange exchange) -> {
            CorsConfiguration corsConfig = new CorsConfiguration();
            corsConfig.addAllowedOrigin("*"); // 허용할 Origin 설정 (모든 Origin 허용)
            corsConfig.addAllowedMethod("*"); // 모든 HTTP 메서드 허용
            corsConfig.addAllowedHeader("*"); // 모든 헤더 허용
            return Mono.just(corsConfig).block();
        });
    }
}
