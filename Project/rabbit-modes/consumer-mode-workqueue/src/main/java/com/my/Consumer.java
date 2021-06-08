package com.my;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
@RabbitListener(queues = "myQueue")
public class Consumer {
    @RabbitHandler
    public void receive(Map msg){
        String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("### Conusumer1 ### receive: " + msg.toString() + "current time is:" + nowTime);
    }
}
