package com.spdb.xiyou;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Main8401 {
    public static void main(String[] args) {
        SpringApplication.run(Main8401.class,args);
    }

    @RestController
    class EchoController {
        @GetMapping(value = "/test1")
        public String echo() {
            return "test1";
        }
        @GetMapping(value = "/test2")
        public String echo2() {
            return "test2";
        }

        @GetMapping(value = "/testHotKey")
        @SentinelResource(value = "hotkey",blockHandler = "testHandler")
        public String echo3(
                @PathVariable(value = "p1",required = false)  String p1,
                @PathVariable(value = "p2",required = false)  String p2
        ) {
            return "test2";
        }

        public String testHandler(String p1, String p2, BlockException e){
            return "please wati a minute";
        }
    }

}
