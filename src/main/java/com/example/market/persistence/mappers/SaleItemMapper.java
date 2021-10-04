package com.example.market.persistence.mappers;

import com.example.market.domain.SaleItem;
import com.example.market.persistence.entities.DbSaleDetail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleItemMapper {

    @Mapping(source = "id.productId", target = "productId")
    SaleItem fromSaleItem(DbSaleDetail detail);

    @InheritInverseConfiguration
    DbSaleDetail toSaleItem(SaleItem item);
}
