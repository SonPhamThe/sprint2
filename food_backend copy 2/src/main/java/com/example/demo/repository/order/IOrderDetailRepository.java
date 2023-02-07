package com.example.demo.repository.order;

import com.example.demo.model.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "select od.* from order_detail as od join orders as o on o.id = od.order_id join payment as p on o.id = p.order_id join user as u on u.id = o.user_id where u.id = :idUser and p.payment_status = 0", nativeQuery = true)
    List<OrderDetail> getListFoodByUser(@Param("idUser") int idUser);
}
