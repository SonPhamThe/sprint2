package com.example.demo.service.order;

import com.example.demo.model.order.Orders;

public interface IOrderService {
    Orders getOrder(int idUser);

    void save(Orders newOrder);
}
