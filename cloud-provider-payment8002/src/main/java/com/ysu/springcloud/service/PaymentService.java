package com.ysu.springcloud.service;

import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;

public interface PaymentService {
    Payment selectById(int id);

    int insert(Payment payment);
}
