package com.example.market.persistence.mappers;

import com.example.market.domain.Product;
import com.example.market.persistence.entities.DbProduct;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    DbProduct toProduct(Product product);
    List<Product> fromProducts(List<DbProduct> products);
    Product fromProduct(DbProduct product);
}
