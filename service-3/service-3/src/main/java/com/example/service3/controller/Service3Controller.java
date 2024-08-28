package com.example.service3.controller;

import com.example.service3.Payload;
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
    private static final Logger logger= LoggerFactory.getLogger(Service3Controller.class);

    @PostMapping("/name")
    public ResponseEntity<String> processName(@Valid @RequestBody Payload payload){
        logger.info("Received payload: {}", payload);
        String concatenatedName= payload.getName() + " " + payload.getSurname();
        return ResponseEntity.ok(concatenatedName);
    }
}
