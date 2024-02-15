package com.example.webflux102;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EchoController {
    @GetMapping("/ping")
    public Mono<String> hello() {
        return Mono.just("Pong!");
    }
}
