package com.example.service3.controller;

import com.example.service3.Payload;
import com.example.service3.service.Service3Class;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service3")
@Validated
public class Service3Controller {
    private final Service3Class service;

    public Service3Controller(Service3Class service){
        this.service=service;
    }

    @PostMapping("/name")
    public ResponseEntity<String> concatenateName(@Valid @RequestBody Payload payload){
        return service.concatenateName(payload);
    }
}
