package com.my;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
@RabbitListener(queues = "${my.consumer.queue1}")
public class Consumer {
    @RabbitHandler
    public int pow(Integer x) throws Exception{
        System.out.println("## receive" + x + "##");
        return  x * x;
    }
}
