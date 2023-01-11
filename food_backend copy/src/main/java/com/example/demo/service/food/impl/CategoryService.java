package com.example.demo.service.food.impl;

import com.example.demo.repository.model.food.Category;
import com.example.demo.repository.food.ICategoryRepository;
import com.example.demo.service.food.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> showAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Integer category) {
        return categoryRepository.findById(category).orElse(null);
    }
}
