package com.example.exam.repository;

import com.example.exam.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where product.code like %:any% or product.name like %:any%", nativeQuery = true)
    List<Product> showAllProduct(@Param("any") String any);

    @Query(value = "select * from product where product.code like %:code%", nativeQuery = true)
    List<Product> findProductByCode(@Param("code") String code);

    @Query(value = "select * from product where product.name like %:name%", nativeQuery = true)
    List<Product> findProductByName(@Param("name") String name);
}
