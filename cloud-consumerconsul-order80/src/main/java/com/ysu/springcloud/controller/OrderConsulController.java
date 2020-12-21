package com.ysu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderConsulController {
    @Autowired
    private RestTemplate restTemplate;

    private final String INVOME_URL = "http://consul-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public String payment(){
        return restTemplate.getForObject(INVOME_URL+"/payment/consul",String.class);
    }
}
