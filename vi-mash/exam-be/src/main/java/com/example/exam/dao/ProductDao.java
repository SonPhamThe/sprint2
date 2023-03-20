package com.example.exam.dao;

import com.example.exam.model.Product;
import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class ProductDao {
    private String code;

    private String name;
}
