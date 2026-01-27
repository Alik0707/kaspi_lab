package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String test() {
        return "Products controller is working";
    }

    @GetMapping("/all")
    public CompletableFuture<ResponseEntity<List<Product>>> findAll() {
        return service.findAllAsync()
                .thenApply(products -> ResponseEntity.ok(products));
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }
}