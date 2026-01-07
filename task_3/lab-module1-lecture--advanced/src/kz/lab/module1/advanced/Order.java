package kz.lab.module1.advanced;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public record Order(long id, double price, LocalDateTime orderDate, Set<String> items) {

    public Order {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        if (orderDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Order date must be in the past");
        }
        // Создаём неизменяемый сет
        items = Collections.unmodifiableSet(new HashSet<>(items));
    }
}
