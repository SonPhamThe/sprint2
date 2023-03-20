package com.example.exam.service;

import com.example.exam.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

public interface IProductService {

    List<Product> listProduct();
    List<Product> showAllProduct(String any);

    void createProduct(Product product);
}
