package com.ysu.springcloud.dao;


import com.ysu.springcloud.entitles.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    Payment selectById(int id);
    int insert(Payment payment);
}
