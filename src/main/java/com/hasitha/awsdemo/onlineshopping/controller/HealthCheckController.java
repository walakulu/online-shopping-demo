package com.hasitha.awsdemo.onlineshopping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Map<String, String>> healthCheck() {
        return ResponseEntity.ok(Map.of("message", "OK"));
    }
}
