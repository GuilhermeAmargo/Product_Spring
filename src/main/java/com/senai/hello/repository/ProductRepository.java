package com.senai.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.hello.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}