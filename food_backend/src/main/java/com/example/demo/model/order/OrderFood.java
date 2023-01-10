package com.example.demo.model.order;

import com.example.demo.model.food.Food;
import com.example.demo.model.payment.Payment;
import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonBackReference
    private Food food;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "orderFood")
    @JsonBackReference
    private Payment payment;

    public OrderFood() {
    }

    public OrderFood(Integer id, Integer quantity, Boolean deleteStatus, Food food, User user, Payment payment) {
        this.id = id;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.food = food;
        this.user = user;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
