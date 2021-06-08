package com.my;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class Config {
    @Autowired
    private Environment env;

    @Bean
    public Queue myQueue(){

        return new Queue(env.getProperty("my.provider.queue1"));
    }
    @Bean
    Queue myQueue1(){
        return new Queue(env.getProperty("my.provider.queue2"));
    }

    @Bean
    public TopicExchange myExchange(){
        return new TopicExchange(env.getProperty("my.provider.exchange"));
    }

    @Bean
    Binding bindingQueue1(){
        return BindingBuilder.bind(myQueue())
                .to(myExchange()).with("first.#");
    }
    @Bean
    Binding bindingQueue2(){
        return BindingBuilder.bind(myQueue1())
                .to(myExchange()).with("first.*.second.c");
    }
}
