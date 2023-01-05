package com.example.demo.model.food;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class ImgUrlFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @JsonManagedReference
    private Food food;

    public ImgUrlFood() {
    }

    public ImgUrlFood(Integer id, String url, Food food) {
        this.id = id;
        this.url = url;
        this.food = food;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
