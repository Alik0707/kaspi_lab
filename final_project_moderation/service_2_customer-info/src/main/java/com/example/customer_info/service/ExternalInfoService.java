package com.example.customer_info.service;


import com.example.customer_info.model.ExtendedClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExternalInfoService {
    @Autowired
    private RedisTemplate<String, ExtendedClientInfo> redisTemplate;

    public ExtendedClientInfo getInfo(String clientId) {
        return redisTemplate.opsForValue().get(clientId); // если null — сервис вернёт null
    }
}

