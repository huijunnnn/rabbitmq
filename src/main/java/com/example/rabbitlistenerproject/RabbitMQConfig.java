package com.example.rabbitlistenerproject;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author huijunhong
 */
@Configuration
public class RabbitMQConfig {

    private static final String MY_QUEUE ="MyQueue";

    @Bean
    Queue myQueue(){
        return new Queue(MY_QUEUE,true);//第二个参数 true 表示队列是持久化的，即在 RabbitMQ 服务器重启后仍然存在。
    }

    @Bean
    Exchange myExchange(){
        return ExchangeBuilder
                .topicExchange("MyTopicExchange")
                .durable(true)
                .build();
    }

    @Bean
    Binding binding(){
        return BindingBuilder
                .bind(myQueue())
                .to(myExchange())
                .with("topic")
                .noargs();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }
    @Bean
    MessageListenerContainer messageListenerContainer(){

        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        //通过调用 connectionFactory() 方法获取一个连接工厂 bean，并将其设置为监听容器的连接工厂
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        //调用 myQueue() 方法获取一个队列 bean，并将其设置为要监听的队列。
        simpleMessageListenerContainer.setQueues(myQueue());
        //创建了一个 RabbitMQMessageListener 对象，并将其设置为监听容器的消息监听器。
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
        return simpleMessageListenerContainer;
    }


}
