package com.ysu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderZKController {
    @Autowired
    private RestTemplate restTemplate;

    private final String INVOME_URL="http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String pyment(){
        return restTemplate.getForObject(INVOME_URL+"/payment/zk",String.class);
    }
}
