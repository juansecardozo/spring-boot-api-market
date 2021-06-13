package com.example.market.domain.service;

import com.example.market.domain.Product;
import com.example.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getOne(int id) {
        return productRepository.getOne(id);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int id) {
        return getOne(id).map(product -> {
            productRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
