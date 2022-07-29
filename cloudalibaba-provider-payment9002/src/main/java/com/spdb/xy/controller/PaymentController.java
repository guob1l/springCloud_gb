package com.spdb.xy.controller;

import com.spdb.xy.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/payment/{id}")
    public CommonResult load(){

        return new CommonResult(200,"sucess","11111");

    }
}
