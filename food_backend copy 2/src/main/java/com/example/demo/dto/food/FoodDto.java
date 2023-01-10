package com.example.demo.dto.food;

public class FoodDto {
    private int id;

    private String name;
    private double price;

    private String description;

    private String avatarFood;

    private Integer category;

    public FoodDto() {
    }

    public FoodDto(int id, String name, double price, String description, String avatarFood, Integer category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.avatarFood = avatarFood;
        this.category = category;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
