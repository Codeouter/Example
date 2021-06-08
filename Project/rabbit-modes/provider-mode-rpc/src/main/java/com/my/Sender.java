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

    public void  getPow(int x){
       System.out.println("### send " + x + "###");
       Object rep = rabbitTemplate.convertSendAndReceive(env.getProperty("my.provider.exchange"),
               env.getProperty("my.provider.routing1"), x);

       int res = (int) rep;
      System.out.println("### receive the answer is " + res + "  ###");
    }
}
