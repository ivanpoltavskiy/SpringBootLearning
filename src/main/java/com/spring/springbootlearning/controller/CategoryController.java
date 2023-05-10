package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.repository.CategoryRepository;
import com.spring.springbootlearning.search.CategorySearchValues;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> categories(){
        return categoryRepository.findAllByOrderByIdAsc();
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

    @GetMapping("id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = null;
        try{
            category = categoryRepository.findById(id).get();
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id = "+id+" not found!", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(category);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id){
        try {
             categoryRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("id = "+id+" not found!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearchValues categorySearchValues){

        return ResponseEntity.ok(categoryRepository.findByTitle(categorySearchValues.getText()));

    }
}
