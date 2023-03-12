package com.example.demo.model.user;

import com.example.demo.model.account.Account;
import com.example.demo.model.order.Orders;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String Avatar;

    private String dayOfBirth;

    private Boolean gender;

    private String phone;

    private String idCard;

    private Double points;

    @Column(columnDefinition = "boolean default false")
    private Boolean deleteStatus;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "userType_id", referencedColumnName = "id")
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public User() {
    }

    public User(Integer id, String name, String avatar, String dayOfBirth, Boolean gender, String phone, String idCard, Double points, Boolean deleteStatus, Address address, UserType userType, Set<Orders> orders, Account account) {
        this.id = id;
        this.name = name;
        Avatar = avatar;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.phone = phone;
        this.idCard = idCard;
        this.points = points;
        this.deleteStatus = deleteStatus;
        this.address = address;
        this.userType = userType;
        this.orders = orders;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
