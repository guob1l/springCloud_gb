package com.spdb.xy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.spdb.xy.entities.CommonResult;
import com.spdb.xy.entities.Payment;
import com.spdb.xy.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "consumer/payment/ok/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        CommonResult payment = paymentService.ok(id);
        log.info("查询结果:"+payment);
        return payment;
    }

    @GetMapping(value = "consumer/payment/timeout")
    @HystrixCommand(fallbackMethod = "getPaymentByIdFallbackMethod"
    ,commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public CommonResult getPaymentById(){

        CommonResult payment = paymentService.timeout();
        log.info("查询结果:"+payment);
        return payment;
    }


    @GetMapping(value = "consumer/payment/timeoutTwo")
    @HystrixCommand
    public CommonResult timeout(){

        int errorNumber = 1/0;
        CommonResult payment = paymentService.timeout();
        log.info("查询结果:"+payment);
        return payment;
    }


    public CommonResult getPaymentByIdFallbackMethod(){
        return new CommonResult(200,"your speed is too fast,please waiting a minute");
    }



    //global fallBack
    public CommonResult globalFallBack(){

        return new CommonResult(204,"server stop !");
    }

}
