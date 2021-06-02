package com.my;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class Config {
    @Autowired
    private Environment env;

    //队列 起名：TestDirectQueue
    @Bean
    public Queue MyDirectQueue() {
        return new Queue(env.getProperty("mq.consumer.queue"),true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange MyDirectExchange() {
        return new DirectExchange(env.getProperty("mq.consumer.exchange"));
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(MyDirectQueue())
                .to(MyDirectExchange())
                .with(env.getProperty("mq.consumer.routing"));
    }
}
