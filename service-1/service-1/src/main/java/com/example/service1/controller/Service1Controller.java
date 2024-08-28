package com.example.service1.controller;

import com.example.service1.dto.Payload;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;

import java.util.UUID;

@RestController
@RequestMapping("/service1")
@Validated
public class Service1Controller {
    private static final Logger logger= LoggerFactory.getLogger(Service1Controller.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        return ResponseEntity.ok("UP");
    }


    @PostMapping("/concat")
    public ResponseEntity<String> concatenation(@Valid @RequestBody Payload payload){

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
