package com.senai.hello.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.hello.dtos.ProductRequest;
import com.senai.hello.dtos.ProductResponse;
import com.senai.hello.entities.Product;
import com.senai.hello.mappers.ProductMapper;
import com.senai.hello.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponse>getProducts(){
        return repository.findAll()
        .stream()
        .map(ProductMapper::toDTO)
        .toList();
    }

     public ProductResponse getProductById(long id) {
        return repository.findById(id)
                         .map(ProductMapper::toDTO)
                         .orElseThrow( ()-> new EntityNotFoundException("Produto não cadastrado"));
    }
    
    
    public void deleteProduct(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto não existe");
        }
    }
    
    public ProductResponse saveProduct(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        Product savedProduct = repository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    public void updateProduct(Long id, ProductRequest request) {
        Product aux = repository.getReferenceById(id);
        aux.setName(request.name());
        aux.setPrice(request.price());

        repository.save(aux);
    }
}