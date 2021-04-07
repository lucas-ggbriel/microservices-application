package com.oder.order.service;

import com.oder.order.entity.Order;
import com.oder.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order insertOrder(Order order){
        return orderRepository.save(order);
    }
}
