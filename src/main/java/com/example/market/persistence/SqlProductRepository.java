package com.example.market.persistence;

import com.example.market.domain.Product;
import com.example.market.domain.repository.ProductRepository;
import com.example.market.persistence.crud.ProductCrudRepository;
import com.example.market.persistence.entities.DbProduct;
import com.example.market.persistence.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SqlProductRepository implements ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        return mapper.fromProducts((List<DbProduct>) productCrudRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.of(mapper.fromProducts(productCrudRepository.findByCategoryIdOrderByName(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScarce(int stock) {
        Optional<List<DbProduct>> products = productCrudRepository.findByStockLessThanAndActive(stock, true);
        return products.map(prods -> mapper.fromProducts(prods));
    }

    @Override
    public Optional<Product> getOne(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.fromProduct(product));
    }

    @Override
    public Product save(Product product) {
        return mapper.fromProduct(productCrudRepository.save(mapper.toProduct(product)));
    }

    @Override
    public void delete(int id) {
        productCrudRepository.deleteById(id);
    }

}
