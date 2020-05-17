package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//服务提供者的名字
@FeignClient("provider")
@Component
public interface TestFeignClient {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String callHello();
}
