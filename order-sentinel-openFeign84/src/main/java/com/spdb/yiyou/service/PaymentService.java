package com.spdb.yiyou.service;

import com.spdb.xy.entities.CommonResult;
import com.spdb.yiyou.service.fallbackServiceImpl.PaymentServiceFallbakService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceFallbakService.class)
public interface PaymentService {
    @GetMapping("payment/{id}")
     CommonResult load(@PathVariable("id")Long id);
}
