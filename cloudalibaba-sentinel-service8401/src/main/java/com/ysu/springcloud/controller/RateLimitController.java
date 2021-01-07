package com.ysu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;


import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RateLimitController {

    @GetMapping("/by/resource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        CommonResult result =new CommonResult(200, "按资源名称限流测试OK",new Payment(1,"errorSerial"));
        return result;
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用",null);
    }

}
