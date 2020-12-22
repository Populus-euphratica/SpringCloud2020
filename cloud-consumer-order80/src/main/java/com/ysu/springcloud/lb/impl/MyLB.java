package com.ysu.springcloud.lb.impl;

import com.ysu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int num=serviceInstances.size();
        return serviceInstances.get(getAndIncrement(num));
    }

    private int getAndIncrement(int num){
        int current;
        int index;
        do {
            current=atomicInteger.get();
            index=current>=Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,index));
        System.out.println("*******第几次访问，次数next: "+index);
        return index%num;
    }
}
