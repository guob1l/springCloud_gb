package com.spdb.xy.controller;

import com.spdb.xy.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String send(){

        return messageProvider.send();
    }
}
