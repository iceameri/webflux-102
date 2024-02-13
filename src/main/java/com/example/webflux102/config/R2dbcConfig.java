package com.example.webflux102.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class R2dbcConfig {
    //@CreatedBy, @CreatedDate, @LastModifiedBy, @LastModifiedDate annotation을 활성화시켜준다.
}
