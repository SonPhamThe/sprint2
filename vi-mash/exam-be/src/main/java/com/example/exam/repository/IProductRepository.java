package com.example.exam.repository;

import com.example.exam.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    /*
    * Create: SonPT
    * Functions: Show All Product By Page And Search Code and Name
    * */
    @Query(value = "select * from product where product.code like %:any% or product.name like %:any%", nativeQuery = true)
    Page<Product> showAllProductByPage(@Param("any") String any, Pageable pageable);

    /*
     * Create: SonPT
     * Functions: Delete Product By Set delete_status
     * */
    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(value = " UPDATE  product set delete_status = 1 where product.id = :id ", nativeQuery = true)
    void deleteProductById(@Param("id") Integer id);
}
