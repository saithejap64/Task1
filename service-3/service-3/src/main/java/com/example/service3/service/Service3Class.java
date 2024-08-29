package com.example.service3.service;

import com.example.service3.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Service3Class {
    private static final Logger logger= LoggerFactory.getLogger(Service3Class.class);

    public ResponseEntity<String> concatenateName(Payload payload){
        logger.info("Received payload: {}", payload);
        String concatenatedName= payload.getName() + " " + payload.getSurname();
        return ResponseEntity.ok(concatenatedName);
    }
}
