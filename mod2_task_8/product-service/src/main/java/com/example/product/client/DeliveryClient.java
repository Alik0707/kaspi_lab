package com.example.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "delivery", url = "http://localhost:8081")
public interface DeliveryClient {

    @PostMapping("/delivery")
    void createDelivery(@RequestBody Object request);
}
