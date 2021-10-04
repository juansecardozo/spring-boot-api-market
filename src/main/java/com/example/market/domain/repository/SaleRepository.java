package com.example.market.domain.repository;

import com.example.market.domain.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    List<Sale> getAll();
    Optional<List<Sale>> getByCustomer(String customerId);
    Sale save(Sale sale);
}
