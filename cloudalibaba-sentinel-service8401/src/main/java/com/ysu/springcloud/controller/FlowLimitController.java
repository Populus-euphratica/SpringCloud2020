package com.ysu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {
    @SentinelResource("testA")
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }
    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD() {
        int a=10/0;
        return "------testD";
    }


}
