package com.ysu.springcloud.service;

import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;

public interface PaymentService {
    public Payment selectById(int id);

    public int insert(Payment payment);
}
