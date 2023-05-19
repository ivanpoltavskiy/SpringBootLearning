package com.spring.springbootlearning.service;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.exceptions.CategoryNotFoundException;
import com.spring.springbootlearning.repository.CategoryRepository;
import com.spring.springbootlearning.search.CategorySearchValues;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> categories() {
        return categoryRepository.findAllByOrderByIdAsc();
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }


    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with id + " + id + " not found"));
    }

    public void deleteById(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }

    }

    public List<Category> search(CategorySearchValues categorySearchValues) {
        return categoryRepository.findByTitle(categorySearchValues.getText());
    }
}
