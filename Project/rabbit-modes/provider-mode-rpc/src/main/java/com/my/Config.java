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
    public DirectExchange myExchange(){
        return new DirectExchange(env.getProperty("my.provider.exchange"));
    }

    @Bean
    public Binding binding(){
       return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with(env.getProperty("my.provider.routing1"));
    }
}
