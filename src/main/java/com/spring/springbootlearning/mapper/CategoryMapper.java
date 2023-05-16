package com.spring.springbootlearning.mapper;

import com.spring.springbootlearning.dto.request.category.CategoryCreateRequest;
import com.spring.springbootlearning.dto.response.category.CategoryResponse;
import com.spring.springbootlearning.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "title", source = "entity.title")
    @Mapping(target = "completedCount", source = "entity.completedCount")
    @Mapping(target = "uncompletedCount", source = "entity.uncompletedCount")
    CategoryResponse toDto(Category entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "completedCount", source = "dto.completedCount")
    @Mapping(target = "uncompletedCount", source = "dto.uncompletedCount")
    Category fromDto(CategoryCreateRequest dto);
}
