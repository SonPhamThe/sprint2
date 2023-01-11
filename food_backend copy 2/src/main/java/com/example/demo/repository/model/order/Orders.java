package com.example.demo.repository.model.order;

import com.example.demo.repository.model.food.Food;
import com.example.demo.repository.model.payment.Payment;
import com.example.demo.repository.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer quantity;
    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @JsonBackReference
    @ManyToMany(mappedBy = "orders")
    private Set<Food> foods;

    @OneToOne(mappedBy = "order")
    @JsonBackReference
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonManagedReference
    private User user;

    public Orders() {
    }

    public Orders(int id, Integer quantity, Boolean deleteStatus, Set<Food> foods, Payment payment, User user) {
        this.id = id;
        this.quantity = quantity;
        this.deleteStatus = deleteStatus;
        this.foods = foods;
        this.payment = payment;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
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
