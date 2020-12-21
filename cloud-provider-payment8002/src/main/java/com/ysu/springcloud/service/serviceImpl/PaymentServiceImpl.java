package com.ysu.springcloud.service.serviceImpl;

import com.ysu.springcloud.dao.PaymentDao;
import com.ysu.springcloud.entitles.Payment;
import com.ysu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment selectById( int id) {
        return paymentDao.selectById(id);
    }

    @Override
    public int insert( Payment payment) {
        return paymentDao.insert(payment);
    }
}
