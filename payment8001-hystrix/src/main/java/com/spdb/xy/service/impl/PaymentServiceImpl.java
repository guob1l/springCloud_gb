package com.spdb.xy.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spdb.xy.dao.PaymentDao;
import com.spdb.xy.entities.CommonResult;
import com.spdb.xy.entities.Payment;
import com.spdb.xy.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * @Description: normal access
     * @Param:
     * @return:
     * @Author: gb
     * @Date: 2021/4/5
     */
    @Override
    public String  getPaymentById(Long id) {

        return "线程池："+Thread.currentThread().getName()+"paymentOk";

    }

    /**
     * @Description: 超时||报错 =》服务降级
     * @Param:
     * @return:
     * @Author: gb
     * @Date: 2021/4/5
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",
    commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentTimeout(){

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            log.error("{}",e);
        }
       return "线程池："+Thread.currentThread().getName()+"paymentTimeout";

    }

    public String paymentInfo_timeoutHandler(){

        return   "线程池："+Thread.currentThread().getName()+"please waiting a minute";

    }


    /**
     * @Description: 服务熔断
     * @Param:
     * @return:
     * @Author: gb
     * @Date: 2021/4/6
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
            commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled",value="true")//开启断路
    ,@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10")//请求次数
    ,@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000")//时间窗口
    ,@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")})//失败率阈值
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){

        if(id<0){
            throw new RuntimeException("runtime error");

        }else {
            return "线程池："+Thread.currentThread().getName()+"paymentOk";

        }
    }



    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){

        return "server circuitBreaker";
    }
}
