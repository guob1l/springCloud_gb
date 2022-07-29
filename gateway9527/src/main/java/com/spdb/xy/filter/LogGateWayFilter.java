package com.spdb.xy.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class LogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

         String userName = exchange.getRequest().getQueryParams().getFirst("userName");
         if(StringUtils.isEmpty(userName)){
                exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
             return exchange.getResponse().setComplete();
         }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
