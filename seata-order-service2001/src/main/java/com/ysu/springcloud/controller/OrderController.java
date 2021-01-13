package com.ysu.springcloud.controller;

import com.ysu.springcloud.domain.CommonResult;
import com.ysu.springcloud.domain.Order;
import com.ysu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult<Order> create(Order order){
        orderService.create(order);
        return new CommonResult<Order>(200,"订单创建成功");
    }
}
