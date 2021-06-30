package com.oder.order.message;

import com.oder.order.dto.ClientOrderDto;
import org.springframework.messaging.handler.annotation.Payload;

public class ClientReceiveMessage {

    public void receiveMessage(@Payload ClientOrderDto clientOrderDto){

    }
}
