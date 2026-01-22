package com.example.product.service;

import com.example.product.client.DeliveryClient;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final DeliveryClient deliveryClient;

    public ProductService(ProductRepository repository,
                          DeliveryClient deliveryClient) {
        this.repository = repository;
        this.deliveryClient = deliveryClient;
    }

    @Async("productAsyncExecutor")
    public CompletableFuture<List<Product>> findAllAsync() {
        List<Product> products = repository.findAll();

        return CompletableFuture.completedFuture(products);
    }

    public Product save(Product product) {
        Product saved = repository.save(product);

        deliveryClient.createDelivery(
                Map.of(
                        "productId", saved.getId(),
                        "address", saved.getAddress()
                )
        );

        return saved;
    }
}