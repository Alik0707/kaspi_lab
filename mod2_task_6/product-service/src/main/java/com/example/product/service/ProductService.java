package com.example.product.service;

import com.example.product.client.DeliveryClient;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final DeliveryClient deliveryClient;

    public ProductService(ProductRepository repository,
                          DeliveryClient deliveryClient) {
        this.repository = repository;
        this.deliveryClient = deliveryClient;
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
