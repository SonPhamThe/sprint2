package com.example.demo.controller.food;

import com.example.demo.dto.food.ImgUrlFoodDto;
import com.example.demo.model.food.Food;
import com.example.demo.model.food.ImgUrlFood;
import com.example.demo.service.food.IFoodService;
import com.example.demo.service.food.IImgFoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/images")
public class ImgFoodRestController {
    @Autowired
    private IFoodService foodService;

    @Autowired
    private IImgFoodService imgFoodService;

    @GetMapping("/find/{id}")
    public ResponseEntity<List<ImgUrlFood>> getImgFoodById(@PathVariable int id) {
        List<ImgUrlFood> listImg = imgFoodService.listImgFood(id);
        if (listImg.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImg, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> saveImgFood(@Validated @RequestBody ImgUrlFoodDto imgUrlFoodDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlFood imgUrlFood = new ImgUrlFood();
        BeanUtils.copyProperties(imgUrlFoodDTO, imgUrlFood);
        Food food = foodService.getFood(imgUrlFoodDTO.getFood());
        imgUrlFood.setFood(food);
        imgFoodService.saveImgFood(imgUrlFood);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
