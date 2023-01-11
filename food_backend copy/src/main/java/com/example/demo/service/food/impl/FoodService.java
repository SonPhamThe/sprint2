package com.example.demo.service.food.impl;

import com.example.demo.repository.model.food.Food;
import com.example.demo.repository.food.IFoodRepository;
import com.example.demo.service.food.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository foodRepository;


    @Override
    public List<Food> showAllFood(String name) {
        return foodRepository.showAllFood(name);
    }

    @Override
    public void saveFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public Food getFood(Integer id) {
        return foodRepository.findById(id).orElse(null);
    }
}
