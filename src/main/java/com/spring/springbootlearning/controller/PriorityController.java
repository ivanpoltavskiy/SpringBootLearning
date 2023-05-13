package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.repository.PriorityRepository;
import com.spring.springbootlearning.search.PrioritySearchValues;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping ("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    @GetMapping()
    public List<Priority> priorities(){
        return priorityRepository.findAllByOrderByIdAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add (@RequestBody Priority priority){
        if (priority.getId() !=null && priority.getId() != 0){
            return new ResponseEntity("ID should be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (priority.getTitle() == null || priority.getTitle().trim().length() == 0){
            return new ResponseEntity("Title cannot be null", HttpStatus. NOT_ACCEPTABLE);
        }
        if (priority.getColor() == null || priority.getColor().trim().length() == 0){
            return new ResponseEntity("Color cannot be null", HttpStatus. NOT_ACCEPTABLE);
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
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id){
        Priority priority = null;
        try{
            priority = priorityRepository.findById(id).get();
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id = "+id+" not found!", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priority);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Priority> deleteById(@PathVariable Long id){
        try {
            priorityRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("id = "+id+" not found!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PrioritySearchValues prioritySearchValues){

        return ResponseEntity.ok(priorityRepository.findByTitle(prioritySearchValues.getText()));

    }
}
