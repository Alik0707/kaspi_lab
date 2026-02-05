package com.example.customer_info.controller;

import com.example.customer_info.model.ExtendedClientInfo;
import com.example.customer_info.service.ExternalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external")
public class ExternalInfoController {
    @Autowired
    private ExternalInfoService service;

    @GetMapping("/{clientId}")
    public ResponseEntity<ExtendedClientInfo> getInfo(@PathVariable String clientId) {
        ExtendedClientInfo info = service.getInfo(clientId);
        return ResponseEntity.ok(info != null ? info : new ExtendedClientInfo());
                                /*
                                if (info != null) {
                                    result = info;  если info существует, берём его
                                } else {
                                    result = new ExtendedClientInfo();  иначе создаём новый пустой объект
                                }*/
    }
}

