package com.example.exam.controller;

import com.example.exam.model.Product;
import com.example.exam.service.IProductService;
import com.example.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/show")
    public ResponseEntity<List<Product>> showAllFoodByAny(@RequestParam(required = false, defaultValue = "") String any) {
        List<Product> productList = iProductService.showAllProduct(any);
        if(productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/find/{code}")
    public ResponseEntity<List<Product>> findProductByCode(@PathVariable() String code) {
        List<Product> productList = iProductService.findProductByCode(code);
        if(productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable() String name) {
        List<Product> productList = iProductService.findProductByCode(name);
        if(productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
