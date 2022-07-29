package com.spdb.xy.service;

import com.spdb.xy.entities.CommonResult;
import com.spdb.xy.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT",fallback = PaymentFallBackService.class)
public interface PaymentService {
    @GetMapping(value = "payment/ok/{id}")
    public CommonResult ok(@PathVariable("id") Long id);

    @GetMapping(value = "payment/timeout")
    public CommonResult timeout();
}
