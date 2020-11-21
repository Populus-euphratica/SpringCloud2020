package com.ysu.springcloud.controller;

import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/customer/payment")
public class OrderController {
    public static final String PAYMENT_URL="http://localhost:8001/payment/";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/id")
    public CommonResult<Payment> selectById(@RequestParam int id){
        return restTemplate.getForObject(PAYMENT_URL+"id?id="+id,CommonResult.class);
    }

    @GetMapping("/")
    public CommonResult<Payment> insert(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL,payment,CommonResult.class);
    }
}
