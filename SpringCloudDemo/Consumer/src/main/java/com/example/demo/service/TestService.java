package com.example.demo.service;


import com.example.demo.feign.TestFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {
    @Autowired
    RestTemplate restTemplate;
    private static final String URL="http://provider/hello";

    @Autowired
    TestFeignClient testFeignClient;
    @HystrixCommand(fallbackMethod = "callError")
    public String callHello(){
        return restTemplate.getForObject(URL,String.class);
    }

    @HystrixCommand(fallbackMethod = "callError")
    public String callFeignHello(){
        return testFeignClient.callHello();
    }

    public String callError(){
        return "call error!";
    }
}
