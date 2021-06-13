package com.example.market.domain.repository;

import com.example.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarce(int stock);
    Optional<Product> getOne(int id);
    Product save(Product product);
    void delete(int id);
}
