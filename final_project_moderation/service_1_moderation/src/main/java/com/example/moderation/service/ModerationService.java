package com.example.moderation.service;

import com.example.moderation.model.ClientRequest;

import com.example.moderation.model.ExtendedClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ModerationService {
    @Autowired
    private KafkaTemplate<String, ClientRequest> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private Set<String> processedEventIds = ConcurrentHashMap.newKeySet();

    public void moderate(ClientRequest request) {
        // Идемпотентность
        if (!processedEventIds.add(request.getEventId())) return;

        // Получаем расширенную информацию
        ExtendedClientInfo info = restTemplate.getForObject(
                "http://service-2-external:8082/external/" + request.getClientId(), ExtendedClientInfo.class);

        // Правила модерации (минимум)
        boolean hasActiveRequest = false; // можно хранить Map<clientId, category>
        boolean inWorkingTime = request.getTimestamp().getHour() >= 9 && request.getTimestamp().getHour() <= 18;

        if (!hasActiveRequest && inWorkingTime) {
            kafkaTemplate.send("topic-2", request);
        }
    }
}
