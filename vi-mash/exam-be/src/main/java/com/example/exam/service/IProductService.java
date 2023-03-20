package com.example.exam.service;

import com.example.exam.dao.BaseResponseDao;
import com.example.exam.dao.ProductDao;
import com.example.exam.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

public interface IProductService {
    /*
     * Create: SonPT
     * Functions: Show All Product By Page And Search Code And Name
     * Param: any: String
     * */
    Page<Product> showAllProductByPage(String any, Pageable pageable);

    /*
     * Create: SonPT
     * Functions: Create New Product
     * */
    BaseResponseDao createProduct(ProductDao productDao);

    /*
     * Create: SonPT
     * Functions: Find Product By ID
     * Param: id: Integer
     * */
    Optional<Product> findByIdProduct(Integer id);

    /*
     * Create: SonPT
     * Functions: Remove Product ( By Reset ID )
     * Param: id: Integer
     * */
    void removeProduct(Integer id);
}
