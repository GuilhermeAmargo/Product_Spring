package com.senai.hello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.hello.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}