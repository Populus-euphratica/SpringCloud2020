package com.ysu.springcloud.service;

import com.ysu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    //新建订单
    void create(Order order);
}
