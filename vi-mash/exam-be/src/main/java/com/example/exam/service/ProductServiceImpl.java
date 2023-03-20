package com.example.exam.service;

import com.example.exam.dao.BaseResponseDao;
import com.example.exam.dao.ProductDao;
import com.example.exam.model.Product;
import com.example.exam.repository.IProductRepository;
import com.example.exam.utils.GenerateBaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    /*
     * Create: SonPT
     * Functions: Show All Product By Page And Search Code And Name
     * Param: any: String
     * */
    @Override
    public Page<Product> showAllProductByPage(String any, Pageable pageable) {
        return iProductRepository.showAllProductByPage(any, pageable);
    }


    /*
     * Create: SonPT
     * Functions: Create New Product
     * return: Message Of Response
     * */
    @Override
    public BaseResponseDao createProduct(ProductDao productDao) {
        Product product = Product.builder()
                .code(productDao.getCode())
                .name(productDao.getName())
                .build();
        product = iProductRepository.save(product);
        return GenerateBaseResponse.successGetResponse("Save Success", product.getId());
    }


    /*
     * Create: SonPT
     * Functions: Find Product By ID
     * Param: id: Integer
     * */
    @Override
    public Optional<Product> findByIdProduct(Integer id) {
        return iProductRepository.findById(id);
    }

    /*
     * Create: SonPT
     * Functions: Remove Product ( By Reset ID )
     * Param: id: Integer
     * */
    @Override
    public void removeProduct(Integer id) {
        iProductRepository.deleteProductById(id);
    }


}
