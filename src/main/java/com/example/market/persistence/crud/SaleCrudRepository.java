package com.example.market.persistence.crud;

import com.example.market.persistence.entities.DbSale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SaleCrudRepository extends CrudRepository<DbSale, Integer> {
    Optional<List<DbSale>> findByCustomerId(String customerId);
}
