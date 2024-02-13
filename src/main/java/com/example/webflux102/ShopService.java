package com.example.webflux102;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final WebClient webClient;

    public ShopService(ShopRepository shopRepository, WebClient.Builder webClientBuilder) {
        this.shopRepository = shopRepository;
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<ShopRes> fetchData(Long id) {
        return webClient.get()
                .uri("/shop/{id}", id)
                .retrieve()
                .bodyToMono(ShopRes.class);
    }

    public Flux<Shop> findAll() {
        return shopRepository.findAll();
    }

    public Mono<Shop> findById(Long id) {
        return shopRepository.findById(id);
    }


    public Mono<Shop> save(Shop shop) {
        return shopRepository.save(shop);
    }

    public Mono<Void> deleteById(Long id) {
        return shopRepository.deleteById(id);
    }
}
