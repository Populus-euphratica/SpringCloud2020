package com.ysu.springcloud.controller;

import com.ysu.springcloud.entitles.CommonResult;
import com.ysu.springcloud.entitles.Payment;
import com.ysu.springcloud.lb.LoadBalancerabc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE/payment/";
    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerabc loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/id")
    public CommonResult selectById(@RequestParam int id){
        return restTemplate.getForObject(PAYMENT_URL+"id?id="+id,CommonResult.class);
    }

    @GetMapping("/")
    public CommonResult insert(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL,payment,CommonResult.class);
    }
    @GetMapping("/lb")
    public String getPaymentLB(){
        List<ServiceInstance> serviceInstanceList= discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (serviceInstanceList.size()<=0||serviceInstanceList==null){
            return null;
        }
        ServiceInstance serviceInstance=loadBalancer.instances(serviceInstanceList);
        URI uri=serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }



}
