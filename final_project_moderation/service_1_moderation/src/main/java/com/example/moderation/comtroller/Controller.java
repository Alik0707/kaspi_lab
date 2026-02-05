package com.example.moderation.comtroller;

import com.example.moderation.model.ClientRequest;
import com.example.moderation.service.ModerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Autowired
    private ModerationService service;

    @KafkaListener(topics = "topic-1", groupId = "moderation-group")
    public void listen(ClientRequest request) {
        service.moderate(request);
    }
}
