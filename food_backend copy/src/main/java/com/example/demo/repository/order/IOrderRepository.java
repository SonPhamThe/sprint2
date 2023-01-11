package com.example.demo.repository.order;

import com.example.demo.model.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<Orders, Integer> {
}
