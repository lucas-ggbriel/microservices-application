package com.oder.order.controller;

import com.oder.order.dto.OrderDto;
import com.oder.order.entity.Order;
import com.oder.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/insert")
    public ResponseEntity insertOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.insertOrder(Order.create(orderDto)));
    }
}
