package com.example.exam.controller;

import com.example.exam.dao.ProductDao;
import com.example.exam.model.Product;
import com.example.exam.service.IProductService;
import com.example.exam.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> productList = iProductService.listProduct();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("show")
    public ResponseEntity<List<Product>> showAllFoodByAny(@RequestParam(required = false, defaultValue = "") String any) {
        List<Product> productList = iProductService.showAllProduct(any);
        if(productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody ProductDao productDao, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDao, product);
        iProductService.createProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
