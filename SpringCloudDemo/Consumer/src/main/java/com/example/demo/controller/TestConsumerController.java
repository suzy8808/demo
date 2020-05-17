package com.example.demo.controller;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConsumerController {
    @Autowired
    private TestService testService;

    @RequestMapping("callHello")
    public String callHello(){
        return testService.callHello();
    }

    @RequestMapping("callFeignHello")
    public String callFeignHello(){
        return testService.callFeignHello();
    }
}
