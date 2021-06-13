package com.example.market.persistence.crud;

import com.example.market.persistence.entities.DbProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<DbProduct, Integer> {
    List<DbProduct> findByCategoryIdOrderByName(int CategoryId);
    Optional<List<DbProduct>> findByStockLessThanAndActive(int stock, boolean active);
}
