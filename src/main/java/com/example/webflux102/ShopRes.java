package com.example.webflux102;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopRes {
    private String name;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public ShopRes(String name, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
