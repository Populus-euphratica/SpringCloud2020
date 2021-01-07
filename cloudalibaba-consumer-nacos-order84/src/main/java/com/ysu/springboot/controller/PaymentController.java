package com.ysu.springboot.controller;

import com.ysu.springboot.service.PaymentService;
import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    // OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") int id) {
        return paymentService.paymentSQL(id);
    }


}
