package com.example.demo.service.order.impl;

import com.example.demo.model.order.Orders;
import com.example.demo.repository.order.IOrderRepository;
import com.example.demo.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Orders getOrder(int idUser) {
        return orderRepository.getOrder(idUser);
    }

    @Override
    public void save(Orders newOrder) {
        orderRepository.save(newOrder);
    }
}
