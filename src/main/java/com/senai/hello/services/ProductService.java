package com.senai.hello.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.hello.entities.Product;
import com.senai.hello.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product>getProducts(){
        return repository.findAll();
    }

     public Product getProductById(long id) {
        return repository.findById(id)
                         .orElseThrow( ()-> new EntityNotFoundException("Produto não cadastrado"));
    }
    
    
    public void deleteProduct(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Produto não existe");
        }
    }
    
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public void updateProduct(Long id, Product product) {
        Product aux = repository.getReferenceById(id);
        aux.setName(product.getName());
        aux.setPrice(product.getPrice());

        repository.save(aux);
    }
}