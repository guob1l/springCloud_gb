package com.spdb.xy.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder  routes = routeLocatorBuilder.routes();

        routes.route("routh",
                r -> r.path("/guonei")
        .uri("https://www.baidu.com")).build();

        return routes.build();

    }

}
