package com.ysu.springboot.service;


import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult paymentSQL(int id)
    {
        return new CommonResult(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
