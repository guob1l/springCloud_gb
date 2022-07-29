package com.spdb.yiyou.service.fallbackServiceImpl;

import com.spdb.xy.entities.CommonResult;
import com.spdb.yiyou.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallbakService implements PaymentService {

    @Override
    public CommonResult load(Long id) {
        return new CommonResult(444,"please wait a minutes",null);
    }
}
