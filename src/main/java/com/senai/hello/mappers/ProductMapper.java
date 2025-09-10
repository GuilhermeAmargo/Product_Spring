package com.senai.hello.mappers;

import com.senai.hello.entities.Product;
import com.senai.hello.dtos.ProductRequest;
import com.senai.hello.dtos.ProductResponse;;

public class ProductMapper {
    
    public static Product toEntity(ProductRequest request) {
        Product p = new Product();
        p.setName(request.name());
        p.setPrice(request.price());
        return p;
    }

    public static ProductResponse toDTO (Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice()
        );
    }
}