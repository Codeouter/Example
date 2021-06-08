package com.my;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class Sender {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private Environment env;

    public void send(){
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("createTime",createTime);
        rabbitTemplate.convertAndSend(env.getProperty("my.provider.exchange"), env.getProperty("my.provider.routing1"), map);
        rabbitTemplate.convertAndSend(env.getProperty("my.provider.exchange"), env.getProperty("my.provider.routing2"), map);

    }

}
