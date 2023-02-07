package com.example.demo.repository.order;

import com.example.demo.model.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "select o.* from orders as o join payment as p on o.id = p.order_id join user as u on u.id = o.user_id where u.id = :idUser and p.payment_status = 0", nativeQuery = true)
    Orders getOrder(@Param("idUser") int idUser);
}
