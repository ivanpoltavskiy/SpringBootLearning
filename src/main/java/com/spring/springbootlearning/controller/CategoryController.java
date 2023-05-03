package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Category> add (@RequestBody Category category){
        if (category.getId() !=null && category.getId() != 0){
            return new ResponseEntity("ID should be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("Title cannot be null", HttpStatus. NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update (@RequestBody Category category){
        if (category.getId() ==null && category.getId() == 0){
            return new ResponseEntity("ID should not be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("Title cannot be null", HttpStatus. NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

}
