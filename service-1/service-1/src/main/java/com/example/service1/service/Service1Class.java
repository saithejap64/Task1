package com.example.service1.service;

import com.example.service1.controller.Service1Controller;
import com.example.service1.dto.Payload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class Service1Class {
    private static final Logger logger= LoggerFactory.getLogger(Service1Class.class);

    @Autowired
    private RestTemplate restTemplate;
    public ResponseEntity<String> concatenation(Payload payload){
        String traceID = UUID.randomUUID().toString();

        logger.info("[Trace_ID: {}] calling Service-" + "2 GET endpoint", traceID);
        String service2URL = "http://localhost:8082/service2/hello";
        String service2response = restTemplate.getForObject(service2URL, String.class);

        logger.info("[Trace_ID: {}] calling Service-3 POST endpoint", traceID);
        String service3URL = "http://localhost:8083/service3/name";
        String service3response = restTemplate.postForObject(service3URL,payload, String.class);

        String concatResponse= service2response + " " + service3response;
        return ResponseEntity.ok(concatResponse);
    }
}
