package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Stat;
import com.spring.springbootlearning.repository.StatRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/stat")
public class StatController {
    private final StatRepository statRepository;
    private final Long defaultId = 1l;

    @GetMapping
    public ResponseEntity<Stat> findById(){
        return ResponseEntity.ok(statRepository.findById(defaultId).get());
    }
}
