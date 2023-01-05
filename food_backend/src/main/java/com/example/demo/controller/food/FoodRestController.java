package com.example.demo.controller.food;

import com.example.demo.model.food.Category;
import com.example.demo.model.food.Food;
import com.example.demo.service.food.ICategoryService;
import com.example.demo.service.food.IFoodService;
import com.example.demo.service.food.IImgFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/foods")
public class FoodRestController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IFoodService foodService;

    @GetMapping("")
    public ResponseEntity<List<Food>> findAllFood(@RequestParam(required = false, defaultValue = "") String name) {
          List<Food> foodList = foodService.showAllFood(name);
          if(foodList.isEmpty()) {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
          return new ResponseEntity<List<Food>>(foodList, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.showAllCategory();
        if(categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }
}
