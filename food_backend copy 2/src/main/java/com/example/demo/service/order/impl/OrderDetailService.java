package com.example.demo.service.order.impl;

import com.example.demo.model.order.OrderDetail;
import com.example.demo.repository.order.IOrderDetailRepository;
import com.example.demo.service.order.IOrderDetailService;
import com.example.demo.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getListFoodOrderByUserId(int idUser) {
        return orderDetailRepository.getListFoodByUser(idUser);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void delete(Integer id) {
        orderDetailRepository.deleteById(id);
    }
}
