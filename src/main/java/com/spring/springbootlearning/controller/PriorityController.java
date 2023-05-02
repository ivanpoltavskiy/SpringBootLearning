package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.repository.PriorityRepository;
import lombok.AllArgsConstructor;
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
    public Priority add (@RequestBody Priority priority){
        return priorityRepository.save(priority);
    }
}
