package com.example.market.persistence.mappers;

import com.example.market.domain.Sale;
import com.example.market.persistence.entities.DbSale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SaleItemMapper.class})
public interface SaleMapper {

    @Mapping(source = "items", target = "details")
    DbSale toSale(Sale sale);
    List<Sale> fromSales(List<DbSale> sales);

    @InheritInverseConfiguration
    Sale fromSale(DbSale sale);
}
