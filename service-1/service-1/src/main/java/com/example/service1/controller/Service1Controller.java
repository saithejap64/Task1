package com.example.service1.controller;

import com.example.service1.dto.Payload;
import com.example.service1.service.Service1Class;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;


@RestController
@RequestMapping("/service1")
@Validated
public class Service1Controller {
    private static final Logger logger= LoggerFactory.getLogger(Service1Controller.class);

    private final Service1Class service;
    public Service1Controller(Service1Class service){
        this.service=service;
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        return ResponseEntity.ok("UP");
    }


    @PostMapping("/concat")
    public ResponseEntity<String> concatenation(@Valid @RequestBody Payload payload){
        return service.concatenation(payload);
    }
}
