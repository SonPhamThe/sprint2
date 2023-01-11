package com.example.demo.service.food;

import com.example.demo.model.food.ImgUrlFood;

import java.util.List;

public interface IImgFoodService {
    List<ImgUrlFood> listImgFood(Integer id);

    void saveImgFood(ImgUrlFood imgUrlFood);
}
