package com.spdb.xy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String port;


    @StreamListener(Sink.INPUT)
    public void recive(Message<String> message) {
        System.out.println("消费者"+port+"\t接受到的信息:"+message.getPayload());
    }
}
