package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeloWorldController {
    
    @GetMapping("/")
    public String message() {
        return "Welcome to Spring Boot Application";
    }
}
