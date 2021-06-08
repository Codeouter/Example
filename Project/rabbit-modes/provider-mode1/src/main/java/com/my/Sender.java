package com.my;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(){
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend("myQueue", map);
    }

}
