package com.example.demo.model.food;

import com.example.demo.model.order.OrderDetail;
import com.example.demo.model.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    private String description;

    private String avatarFood;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonManagedReference
    private Category category;

    @JsonBackReference
    @OneToMany(mappedBy = "food")
    private Set<ImgUrlFood> imgUrlFoods;

    @JsonBackReference
    @OneToMany(mappedBy = "food")
    private Set<OrderDetail> orderDetails;

    public Food() {
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarFood() {
        return avatarFood;
    }

    public void setAvatarFood(String avatarFood) {
        this.avatarFood = avatarFood;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ImgUrlFood> getImgUrlFoods() {
        return imgUrlFoods;
    }

    public void setImgUrlFoods(Set<ImgUrlFood> imgUrlFoods) {
        this.imgUrlFoods = imgUrlFoods;
    }


}
