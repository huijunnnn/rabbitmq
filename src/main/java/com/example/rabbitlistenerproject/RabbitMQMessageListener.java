package com.example.rabbitlistenerproject;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author huijunhong
 */
public class RabbitMQMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("message=["+new String(message.getBody())+"]");
    }
}
