package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @PostMapping("/add")
    public Category add (@RequestBody Category category){
        return categoryRepository.save(category);
    }


}
