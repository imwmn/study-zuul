package com.wmn.user.controller;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wmn
 * @Date: 2020/4/26 14:25
 */
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class MainController  {
    @GetMapping("/get-user")
    public String get(){

        return "i am a coder,i want to call order-service";
    }
}
