package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.request.category.CategoryCreateRequest;
import com.spring.springbootlearning.dto.response.category.CategoryResponse;
import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.mapper.CategoryMapperImpl;
import com.spring.springbootlearning.search.CategorySearchValues;
import com.spring.springbootlearning.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    private CategoryMapperImpl categoryMapper;

    @GetMapping
    public List<CategoryResponse> categories() {
        return categoryService.categories().stream().map(categoryMapper::toDto).toList();
    }

    @PostMapping("/add")
    public CategoryResponse add(@RequestBody CategoryCreateRequest categoryDto) {
        return categoryMapper.toDto(categoryService.add(categoryMapper.fromDto(categoryDto)));
    }

    @PutMapping("/update")
    public CategoryResponse update(@RequestBody CategoryCreateRequest categoryDto) {
        return categoryMapper.toDto(categoryService.update(categoryMapper.fromDto(categoryDto)));
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        return categoryMapper.toDto(categoryService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);

    }

    @PostMapping("/search")
    public List<Category> search(@RequestBody CategorySearchValues categorySearchValues) {
        return categoryService.search(categorySearchValues);

    }
}
