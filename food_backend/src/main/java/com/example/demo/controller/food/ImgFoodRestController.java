package com.example.demo.controller.food;

import com.example.demo.model.food.ImgUrlFood;
import com.example.demo.service.food.IImgFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/images")
public class ImgFoodRestController {
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
}
