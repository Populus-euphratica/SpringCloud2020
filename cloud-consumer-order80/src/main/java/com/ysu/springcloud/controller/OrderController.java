package com.ysu.springcloud.controller;

import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/payment/";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/id")
    public CommonResult selectById(@RequestParam int id){
        return restTemplate.getForObject(PAYMENT_URL+"id?id="+id,CommonResult.class);
    }

    @GetMapping("/")
    public CommonResult insert(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL,payment,CommonResult.class);
    }
}
