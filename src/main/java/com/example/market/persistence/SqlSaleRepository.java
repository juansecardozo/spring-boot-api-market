package com.example.market.persistence;

import com.example.market.domain.Sale;
import com.example.market.domain.repository.SaleRepository;
import com.example.market.persistence.crud.SaleCrudRepository;
import com.example.market.persistence.entities.DbSale;
import com.example.market.persistence.mappers.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SqlSaleRepository implements SaleRepository {

    @Autowired
    private SaleCrudRepository saleCrudRepository;

    @Autowired
    private SaleMapper mapper;

    @Override
    public List<Sale> getAll() {
        return mapper.fromSales((List<DbSale>) saleCrudRepository.findAll());
    }

    public Optional<List<Sale>> getByCustomer(String customerId) {
        return saleCrudRepository.findByCustomerId(customerId).map(sales -> mapper.fromSales(sales));
    }

    @Override
    public Sale save(Sale sale) {
        DbSale dbSale = mapper.toSale(sale);
        dbSale.getDetails().forEach(detail -> detail.setSale(dbSale));

        return mapper.fromSale(saleCrudRepository.save(dbSale));
    }
}
