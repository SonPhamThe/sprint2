package com.example.demo.service.order;

import com.example.demo.model.order.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderDetailService {
    List<OrderDetail> getListFoodOrderByUserId(int idUser);

    void save(OrderDetail orderDetail);

    void delete(Integer id);
}
