package com.spdb.xy.controller;

import com.spdb.xy.entities.CommonResult;
import com.spdb.xy.entities.Payment;
import com.spdb.xy.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;



    @GetMapping(value = "payment/ok/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        String payment = paymentService.getPaymentById(id);
        log.info("查询结果:"+payment);
        return new CommonResult(200,"sucess",payment);
    }

    @GetMapping(value = "payment/timeout")
    public CommonResult getPaymentById(){

        String payment = paymentService.paymentTimeout();
        log.info("查询结果:"+payment);
        return new CommonResult(404,"fail",payment);
    }

    @GetMapping(value = "payment/circuit/{id}")
    public CommonResult circuiit(@PathVariable("id") Integer id){

        String payment = paymentService.paymentCircuitBreaker(id);
        log.info("查询结果:"+payment);
        return new CommonResult(404,"fail",payment);
    }
}
