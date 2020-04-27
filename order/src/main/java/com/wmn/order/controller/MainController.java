package com.wmn.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wmn
 * @Date: 2020/4/26 14:30
 */
@RestController
public class MainController {
    @GetMapping("get-order")
    public String get(){
        return "i am order service";
    }

}

