package com.example.demo.service.food;

import com.example.demo.model.food.Food;

import java.util.List;

public interface IFoodService {
    List<Food> showAllFood(String name);
}
