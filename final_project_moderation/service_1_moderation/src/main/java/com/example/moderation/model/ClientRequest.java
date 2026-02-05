package com.example.moderation.model;

import java.time.LocalDateTime;

public class ClientRequest {
    private String eventId;
    private String clientId;
    private String category;
    private LocalDateTime timestamp;

    public ClientRequest() {
    }

    public ClientRequest(String category, String clientId, String eventId, LocalDateTime timestamp) {
        this.category = category;
        this.clientId = clientId;
        this.eventId = eventId;
        this.timestamp = timestamp;
    }

    // геттеры и сеттеры


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
