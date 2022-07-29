package com.spdb;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 定义负载均衡策略
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2021/4/5
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
