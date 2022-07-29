package com.spdb.xy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 后端返回json类
 * @Param: 
 * @return: 
 * @Author: gb
 * @Date: 2021/3/29
 */ 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this.code = code;
        this.message = message;
    } 
}
