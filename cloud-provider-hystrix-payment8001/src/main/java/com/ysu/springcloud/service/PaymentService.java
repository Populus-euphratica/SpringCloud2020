package com.ysu.springcloud.service;

public interface PaymentService {


    //成功
    public String paymentInfo_OK(Integer id);

    //失败
    public String paymentInfo_TimeOut(Integer id);
}
