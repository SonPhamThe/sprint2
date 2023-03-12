package com.example.demo.controller.order;

import com.example.demo.dto.order.OrderDto;
import com.example.demo.model.food.Food;
import com.example.demo.model.order.OrderDetail;
import com.example.demo.model.order.Orders;
import com.example.demo.model.payment.Payment;
import com.example.demo.service.food.IFoodService;
import com.example.demo.service.order.IOrderDetailService;
import com.example.demo.service.order.IOrderService;
import com.example.demo.service.order.impl.OrderService;
import com.example.demo.service.payment.IPaymentService;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private IUserService userService;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private IFoodService foodService;

    @GetMapping("cart/{idUser}")
    public ResponseEntity<List<OrderDetail>> getListFoodOrder(@PathVariable int idUser) {
        List<OrderDetail> orderDetails = orderDetailService.getListFoodOrderByUserId(idUser);
        if (orderDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @PostMapping("orderFood")
    public ResponseEntity<Orders> orderFood(@RequestBody OrderDto orderDto) {
        Orders orders = orderService.getOrder(orderDto.getIdUser());
        if (orders == null) {
            Orders newOrder = new Orders();
            newOrder.setUser(userService.getUserById(orderDto.getIdUser()));
            newOrder.setDeleteStatus(true);
            orderService.save(newOrder);

            Orders orderFind = orderService.getOrder(orderDto.getIdUser());

            Payment payment = new Payment();
            payment.setOrder(orderFind);
            payment.setDeleteStatus(true);
            payment.setPaymentStatus(false);

            paymentService.save(payment);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setFood(foodService.getFood(orderDto.getIdFood()));
            orderDetail.setOrders(orderFind);
            orderDetail.setQuantity(orderDto.getQuantity());
            orderDetail.setDeleteStatus(true);

            orderDetailService.save(orderDetail);
            return new ResponseEntity<>(orderFind, HttpStatus.OK);
        }
        OrderDetail orderDetail1 = new OrderDetail();

        Food food = foodService.getFood(orderDto.getIdFood());

        List<OrderDetail> orderDetails = orderDetailService.getListFoodOrderByUserId(orderDto.getIdUser());
        for (OrderDetail x : orderDetails) {
            if (x.getFood().equals(food)) {
                x.setQuantity(x.getQuantity() + orderDto.getQuantity());
                orderDetailService.save(x);
                return new ResponseEntity<>(orders, HttpStatus.OK);
            }
        }
        orderDetail1.setFood(food);
        orderDetail1.setOrders(orders);
        orderDetail1.setQuantity(orderDto.getQuantity());
        orderDetail1.setDeleteStatus(true);
        orderDetailService.save(orderDetail1);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @DeleteMapping("delete/orderDetail/{id}")
    public ResponseEntity<OrderDetail> deleteOrderDetail(@PathVariable Integer id){
        orderDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
