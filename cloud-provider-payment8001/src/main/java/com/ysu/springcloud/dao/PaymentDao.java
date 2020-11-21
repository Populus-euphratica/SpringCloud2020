package com.ysu.springcloud.dao;


import com.ysu.springcloud.entitles.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public Payment selectById(int id);
    public int insert(Payment payment);
}
