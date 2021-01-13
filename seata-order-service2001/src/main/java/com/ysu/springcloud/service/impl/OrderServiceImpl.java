package com.ysu.springcloud.service.impl;

import com.ysu.springcloud.dao.OrderDao;
import com.ysu.springcloud.domain.Order;
import com.ysu.springcloud.service.AccountService;
import com.ysu.springcloud.service.OrderService;
import com.ysu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "order-creat",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("$*********$");

        log.info("开始新建订单");
        orderDao.create(order);
        log.info("新建订单结束");

        log.info("——————————————");

        log.info("开始减库存"+order.getProductId());
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("减库存结束");

        log.info("——————————————");

        log.info("开始减余额"+order.getUserId());
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("减余额结束");

        log.info("——————————————");

        log.info("开始更新订单状态");
        orderDao.update(order.getId());
        log.info("更新订单状态结束");

        log.info("$*********$");
    }


}
