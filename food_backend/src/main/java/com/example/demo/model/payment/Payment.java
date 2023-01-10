package com.example.demo.model.payment;

import com.example.demo.model.food.Food;
import com.example.demo.model.order.OrderFood;
import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String shippingDescription;

    private Boolean paymentStatus;

    @Column(columnDefinition = "int default 1")
    private int quantity;

    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonManagedReference
    private OrderFood orderFood;

    public Payment() {
    }

    public Payment(Integer id, String shippingDescription, Boolean paymentStatus, int quantity, Boolean deleteStatus, OrderFood orderFood) {
        this.id = id;
        this.shippingDescription = shippingDescription;
        this.paymentStatus = paymentStatus;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.orderFood = orderFood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public OrderFood getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(OrderFood orderFood) {
        this.orderFood = orderFood;
    }
}
