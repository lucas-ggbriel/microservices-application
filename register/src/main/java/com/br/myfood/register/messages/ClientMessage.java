package com.br.myfood.register.messages;

import com.br.myfood.register.dto.ClientOrderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientMessage {

    @Value("${register.rabbitmq.exchange}")
    private String exchange;

    @Value("${register.client.rabbitmq.routingkey}")
    private String routingKey;

    private final RabbitTemplate getTemplate;

    public ClientMessage(RabbitTemplate getTemplate) {
        this.getTemplate = getTemplate;
    }

    public void sendMessage(ClientOrderDto clientOrderDto){
        System.out.println(exchange);
        System.out.println(routingKey);
        System.out.println(clientOrderDto);
        getTemplate.convertAndSend(exchange, routingKey, clientOrderDto);
    }
}
