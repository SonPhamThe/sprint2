package com.example.exam.controller;

import com.example.exam.dao.BaseResponseDao;
import com.example.exam.dao.ProductDao;
import com.example.exam.model.Product;
import com.example.exam.service.IProductService;
import com.example.exam.utils.GenerateBaseResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /*
     * Create: SonPT
     * Functions: Show All Product By Page And Search Code And Name
     * Param: any: String
     * Return: Page<Product>
     * */
    @GetMapping("")
    public ResponseEntity<BaseResponseDao> getProduct(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "any", required = false, defaultValue = "") String any) {
        Pageable pageable = PageRequest.of(page, 12);

        Page<Product> entityPage = this.iProductService.showAllProductByPage(any, pageable);
        if (entityPage.getContent().isEmpty()) {
            if (page == 0) {
                return new ResponseEntity<>(GenerateBaseResponse.notFound("Not Found Product By Name Or Code", entityPage), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(GenerateBaseResponse.noContentGetResponse("No Content", entityPage), HttpStatus.OK);
            }
        }
        if (any.isBlank()) {
            return new ResponseEntity<>(GenerateBaseResponse.successGetResponse("Get List Success", entityPage), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(GenerateBaseResponse.successGetResponse("Get List With Search Success", entityPage), HttpStatus.OK);
        }
    }

    /*
     * Create: SonPT
     * Functions: Find Product By ID
     * Param: id = Integer
     * Return: Product
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Optional<Product> product = iProductService.findByIdProduct(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    /*
     * Create: SonPT
     * Functions: Create New Product
     * Return: ProductDao, HttpStatus: OK
     * */
    @PostMapping("/create")
    public ResponseEntity<BaseResponseDao> saveProduct(@RequestBody ProductDao productDao) {
        return new ResponseEntity<>(iProductService.createProduct(productDao), HttpStatus.OK);
    }

    /*
     * Create: SonPT
     * Functions: Remove Product ( By Reset ID )
     * Param: id: Integer
     * Return:Product
     * */
    @GetMapping("/remove/{id}")
    public ResponseEntity<Product> removeProduct(@PathVariable Integer id) {
        Optional<Product> product = iProductService.findByIdProduct(id);
        if (product.isPresent()) {
            iProductService.removeProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
