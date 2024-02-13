package com.example.webflux102;

import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping(produces = "text/event-stream")
    public Flux<ServerSentEvent<Shop>> streamAllShops() {
        return shopService.findAll()
                .map(shop -> ServerSentEvent.<Shop>builder()
                        .data(shop)
                        .build());
    }

    @GetMapping("/{id}")
    public Mono<Shop> getShopById(@PathVariable Long id) {
        return shopService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Shop> createShop(@RequestBody Mono<Shop> shopMono) {
        return shopMono.flatMap(shopService::save);
    }

    @PutMapping("/{id}")
    public Mono<Shop> updateShop(@PathVariable Long id, @RequestBody Mono<Shop> shopMono) {
        return shopService.findById(id)
                .zipWith(shopMono, (existingShop, newShop) -> {
                    existingShop.setName(newShop.getName());
                    existingShop.setContent(newShop.getContent());
                    return existingShop;
                })
                .flatMap(shopService::save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteShop(@PathVariable Long id) {
        return shopService.deleteById(id);
    }
}
