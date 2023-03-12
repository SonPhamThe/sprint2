package com.example.demo.model.order;

import com.example.demo.model.Payments.Payment;
import com.example.demo.model.user.User;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean deleteStatus;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetail> orderDetails;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "user__payment_id", referencedColumnName = "id")
    private User user;

    public Orders() {
    }

    public Orders(Integer id, Boolean deleteStatus, Set<OrderDetail> orderDetails, Payment payment, User user) {
        this.id = id;
        this.deleteStatus = deleteStatus;
        this.orderDetails = orderDetails;
        this.payment = payment;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
