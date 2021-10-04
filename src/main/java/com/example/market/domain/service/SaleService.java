package com.example.market.domain.service;

import com.example.market.domain.Sale;
import com.example.market.domain.repository.SaleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    public List<Sale> getAll() {
        return saleRepository.getAll();
    }

    public Optional<List<Sale>> getByCustomer(String customerId) {
        return saleRepository.getByCustomer(customerId);
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

}
