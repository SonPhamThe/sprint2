package com.example.demo.service.food.impl;

import com.example.demo.model.food.ImgUrlFood;
import com.example.demo.repository.food.IImgFoodRepository;
import com.example.demo.service.food.IImgFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgFoodService implements IImgFoodService {
    @Autowired
    private IImgFoodRepository imgFoodRepository;

    @Override
    public List<ImgUrlFood> listImgFood(Integer id) {
        return imgFoodRepository.listImgFood(id);
    }
}
