package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.repository.PriorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    @GetMapping()
    public List<Priority> get(){
        return priorityRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add (@RequestBody Priority priority){
        if (priority.getId() !=null && priority.getId() != 0){
            return new ResponseEntity("ID should be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("Title cannot be null", HttpStatus. NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }

    @PutMapping("/update")
    public ResponseEntity<Priority> update (@RequestBody Priority priority){
        if (priority.getId() ==null && priority.getId() == 0){
            return new ResponseEntity("ID should not be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("Title cannot be null", HttpStatus. NOT_ACCEPTABLE);
        }
        if (priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("Color cannot be null", HttpStatus. NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityRepository.save(priority));
    }
}
