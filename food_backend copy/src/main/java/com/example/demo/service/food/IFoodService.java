package com.example.demo.service.food;

import com.example.demo.repository.model.food.Food;

import java.util.List;

public interface IFoodService {
    List<Food> showAllFood(String name);

    void saveFood(Food food);

    Food getFood(Integer id);
}
