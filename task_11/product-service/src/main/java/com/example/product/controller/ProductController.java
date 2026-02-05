package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.example.product.service.RequestDeduplicator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final RequestDeduplicator deduplicator;

    public ProductController(ProductService service, RequestDeduplicator deduplicator) {
        this.service = service;
        this.deduplicator = deduplicator;
    }

    @GetMapping
    public Mono<String> test() {
        return Mono.just("Reactive Product Service (WebFlux + R2DBC) is running");
    }

    @GetMapping("/all")
    public Flux<Product> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> create(@RequestBody Product product) {
        if (deduplicator.isDuplicate(product)) {
            return Mono.just(ResponseEntity.ok().build());
        }

        return service.create(product)
                .map(saved -> ResponseEntity.ok(saved))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping("/price-range")
    public Flux<Product> byPrice(@RequestParam double min, @RequestParam double max) {
        return service.findByPriceRange(min, max);
    }
}