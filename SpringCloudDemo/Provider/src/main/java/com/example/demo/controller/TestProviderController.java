package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProviderController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello! I am Provider.";
    }
}
