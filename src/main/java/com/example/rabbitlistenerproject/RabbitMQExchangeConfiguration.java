package com.example.rabbitlistenerproject;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huijunhong
 */
@Configuration
public class RabbitMQExchangeConfiguration {
   //方法创建一个名为 "ExampleChange" 的主题交换机（Topic Exchange）
    @Bean
    Exchange exampleExchange(){
        return new TopicExchange("ExampleChange");
    }

    //交换机 "Example2ndExchange" 被声明为直连交换机，同时也是自动删除的（在没有绑定的队列时自动删除）
    // 而且是内部交换机（只能由交换机绑定到交换机）。
    @Bean
    Exchange example2ndExchange(){
        return ExchangeBuilder
                .directExchange("Example2ndExchange")
                .autoDelete()
                .internal()
                .build();
    }
    @Bean
    Exchange newExchange(){
        return ExchangeBuilder
                .topicExchange("TopicTestExchange")
                .autoDelete()
                .internal()
                .build();
    }
    @Bean
    Exchange fanoutExchange(){
        return ExchangeBuilder
                .fanoutExchange("FanoutExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }
    @Bean
    Exchange headersExchange(){
        return ExchangeBuilder
                .headersExchange("HeadersExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }
}
