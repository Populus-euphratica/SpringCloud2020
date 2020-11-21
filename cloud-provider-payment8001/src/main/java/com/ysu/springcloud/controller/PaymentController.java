package com.ysu.springcloud.controller;

import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import com.ysu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
@GetMapping("/id")
    public CommonResult selectById(@RequestParam int id){
        Payment payment= paymentService.selectById(id);
        log.info("开始搜索id为："+id);
        if (payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"查询失败，您查询的ID为："+id,null);
        }
    }
    @PostMapping("/")
    public CommonResult insert(@RequestBody Payment payment){
        int result=paymentService.insert(payment);
        log.info("开始插入数据库！！！");
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
}
