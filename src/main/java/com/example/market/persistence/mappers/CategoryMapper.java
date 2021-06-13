package com.example.market.persistence.mappers;

import com.example.market.domain.Category;
import com.example.market.persistence.entities.DbCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    DbCategory toCategory(Category category);
    Category fromCategory(DbCategory category);
}
