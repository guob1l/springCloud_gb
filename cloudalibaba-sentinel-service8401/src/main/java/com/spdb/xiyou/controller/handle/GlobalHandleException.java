package com.spdb.xiyou.controller.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.spdb.xy.entities.CommonResult;

public class GlobalHandleException {

    public  static CommonResult handone(BlockException exception){

        return new CommonResult(333,"error",null);
    }
}
