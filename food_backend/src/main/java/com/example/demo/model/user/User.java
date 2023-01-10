package com.example.demo.model.user;

import com.example.demo.model.account.Account;
import com.example.demo.model.food.Food;
import com.example.demo.model.order.OrderFood;
import com.example.demo.model.payment.Payment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
    private Double pointDedication;

    private String birthDay;

    private String idCard;
    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    private UserType userType;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private Set<OrderFood> orderFoods;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonBackReference
    private Account account;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email, String phone, Double pointDedication, String birthDay, String idCard, Boolean deleteStatus, UserType userType, Set<OrderFood> orderFoods, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pointDedication = pointDedication;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.deleteStatus = deleteStatus;
        this.userType = userType;
        this.orderFoods = orderFoods;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPointDedication() {
        return pointDedication;
    }

    public void setPointDedication(Double pointDedication) {
        this.pointDedication = pointDedication;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<OrderFood> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(Set<OrderFood> orderFoods) {
        this.orderFoods = orderFoods;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
