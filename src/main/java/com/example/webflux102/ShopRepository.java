package com.example.webflux102;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ShopRepository extends ReactiveCrudRepository<Shop, Long> {
}
