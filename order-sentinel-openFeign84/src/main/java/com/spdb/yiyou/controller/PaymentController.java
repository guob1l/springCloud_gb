package com.spdb.yiyou.controller;

import com.spdb.xy.entities.CommonResult;
import com.spdb.yiyou.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    @GetMapping("consumer/payment/{id}")
    CommonResult load(@PathVariable("id")Long id){
        return paymentService.load(id);
    }
}
