package com.spdb.xiyou.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.spdb.xiyou.controller.handle.GlobalHandleException;
import com.spdb.xy.entities.CommonResult;
import com.spdb.xy.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试",new Payment(200l,"ser1"));
    }

    public CommonResult handleException(BlockException e){

        return new CommonResult(444,e.getClass().getCanonicalName()+"服务不可勇敢");
    }

    @GetMapping("byResource1")
    @SentinelResource(value = "byResource1",blockHandlerClass = GlobalHandleException.class,blockHandler = "handone")
    public CommonResult byResource1(){
        return new CommonResult(200,"按资源名称限流测试",new Payment(200l,"ser1"));
    }
 }
