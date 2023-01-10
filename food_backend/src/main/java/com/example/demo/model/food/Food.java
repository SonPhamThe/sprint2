package com.example.demo.model.food;

import com.example.demo.model.order.OrderFood;
import com.example.demo.model.payment.Payment;
import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
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
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_food",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "food")
    private Set<OrderFood> orderFoods;

    public Food() {
    }

    public Food(int id, String name, double price, String description, String avatarFood, Category category, Set<ImgUrlFood> imgUrlFoods, Set<User> users, Set<OrderFood> orderFoods) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.avatarFood = avatarFood;
        this.category = category;
        this.imgUrlFoods = imgUrlFoods;
        this.users = users;
        this.orderFoods = orderFoods;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<OrderFood> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(Set<OrderFood> orderFoods) {
        this.orderFoods = orderFoods;
    }
}
