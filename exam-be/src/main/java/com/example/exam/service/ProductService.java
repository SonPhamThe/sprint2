package com.example.exam.service;

import com.example.exam.model.Product;
import com.example.exam.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> listProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public List<Product> showAllProduct(String any) {
        return iProductRepository.showAllProduct(any);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.save(product);
    }
}
