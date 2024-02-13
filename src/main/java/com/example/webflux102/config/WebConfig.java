package com.example.webflux102.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {
    //  JSON 직렬화 및 역직렬화
    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder());
        configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder());
    }
}
