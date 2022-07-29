package com.spdb.xy.service;

import com.spdb.xy.entities.CommonResult;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public CommonResult ok(Long id) {
        return new CommonResult(204,"ok server stop");
    }

    @Override
    public CommonResult timeout() {
        return new CommonResult(204,"timeout server stop  ");
    }
}
