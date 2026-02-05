package com.example.customer_info.model;

public class ExtendedClientInfo {
    private String clientId;
    private String extraData;

    public ExtendedClientInfo() {}
    public ExtendedClientInfo(String extraData, String clientId) {
        this.clientId = clientId;
    }
    // геттеры и сеттеры


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }
}

