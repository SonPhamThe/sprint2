package com.example.demo.model.user;

import com.example.demo.model.account.Account;
import com.example.demo.model.food.Food;
import com.example.demo.model.payment.Payment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    private String avatar;

    private String address;

    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    @JsonManagedReference
    private UserType userType;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonBackReference
    private Account account;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Account account1;

    @JsonBackReference
    @ManyToMany(mappedBy = "users")
    Set<Food> foods = new HashSet<>();

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Payment payment;

    public User() {
    }

    public User(Integer id, String firstName, String lastName, String email, String phone, Double pointDedication, String birthDay, String idCard, String avatar, String address, Boolean deleteStatus, UserType userType, Account account, Account account1, Set<Food> foods, Payment payment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pointDedication = pointDedication;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.avatar = avatar;
        this.address = address;
        this.deleteStatus = deleteStatus;
        this.userType = userType;
        this.account = account;
        this.account1 = account1;
        this.foods = foods;
        this.payment = payment;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount1() {
        return account1;
    }

    public void setAccount1(Account account1) {
        this.account1 = account1;
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
}
