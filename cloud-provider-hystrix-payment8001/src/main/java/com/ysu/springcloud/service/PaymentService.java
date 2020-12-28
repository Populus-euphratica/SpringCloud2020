package com.ysu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {


    //成功
    public String paymentInfo_OK(Integer id);

    //失败
    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id);
}
