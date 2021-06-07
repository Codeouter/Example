package com.mymy;
import com.mymy.Main;
import com.rabbitmq.client.Channel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListenerTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Before
    public void setup(){}
    @Test
    public void receive() throws Exception{
        Channel channel = null;
        Message msg = rabbitTemplate.receive("myQueue");
        Map hello = (Map<String, Object>) rabbitTemplate.receiveAndConvert("myQueue");
        if(msg !=null){
            
//            listener.process(hello, channel,msg);
        }
    }
}
