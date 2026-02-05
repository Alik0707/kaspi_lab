package com.example.product.service;

import com.example.product.model.Product;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RequestDeduplicator {

    private final Cache<String, Long> cache = Caffeine.newBuilder()
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .maximumSize(100_000)
            .build();

    public boolean isDuplicate(Product product) {
        String key = buildKey(product);
        Long lastTime = cache.getIfPresent(key);
        long now = System.currentTimeMillis();

        if (lastTime != null && now - lastTime < 2000) {
            return true;
        }

        cache.put(key, now);
        return false;
    }

    private String buildKey(Product p) {
        return Objects.hash(
                normalize(p.getName()),
                p.getPrice(),
                normalize(p.getAddress())
        ).toString();
    }

    private String normalize(String s) {
        return s == null ? "" : s.trim().toLowerCase();
    }
}