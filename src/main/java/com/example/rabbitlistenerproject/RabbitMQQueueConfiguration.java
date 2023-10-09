package com.example.rabbitlistenerproject;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huijunhong
 */
@Configuration
public class RabbitMQQueueConfiguration {
    //exampleQueue() 方法创建一个名为 "ExampleQueue" 的非持久化队列，即第二个参数为 false。
    @Bean
    Queue exampleQueue(){
        return new Queue("ExampleQueue",false);
    }
    //通过使用 QueueBuilder，可以更灵活地配置队列的属性。
    // 队列 "Example2ndQueue" 被声明为持久化队列（将在 RabbitMQ 服务器重启后保留），同时也是自动删除的（在最后一个消费者断开连接后自动删除），而且是独占的（只能被一个连接使用）。
    @Bean
    Queue example2ndQueue(){
        return QueueBuilder.durable("Example2ndQueue")
                .autoDelete()
                .exclusive()
                .build();
    }

}
