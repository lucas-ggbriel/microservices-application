package com.br.myfood.register.messages;

import com.br.myfood.register.dto.ClientOrderDto;
import com.br.myfood.register.dto.MenuOrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MenuMessage {
    @Value("${register.rabbitmq.exchange}")
    private String exchange;

    @Value("${register.menu.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate getTemplate;

    public MenuMessage(RabbitTemplate getTemplate) {
        this.getTemplate = getTemplate;
    }

    public void sendMessage(MenuOrderDto menuOrderDto){
        System.out.println(exchange);
        System.out.println(routingKey);
        System.out.println(menuOrderDto);
        getTemplate.convertAndSend(exchange, routingKey, menuOrderDto);
    }
}
