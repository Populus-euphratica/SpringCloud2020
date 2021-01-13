package com.ysu.springcloud.controller;

import com.ysu.springcloud.domain.CommonResult;
import com.ysu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;


    //扣减库存
    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam Long productId, @RequestParam Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
