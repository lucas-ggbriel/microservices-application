package com.oder.order.message;

import com.oder.order.dto.MenuOrderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MenuReceiveMessage {

    @RabbitListener(queues = {"${register.menu.rabbitmq.queue}"})
    public void receiveMenuMessage(@Payload MenuOrderDto menuOrderDto){
        System.out.println(menuOrderDto);
    }
}
