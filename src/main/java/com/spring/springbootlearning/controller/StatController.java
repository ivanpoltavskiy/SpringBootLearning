package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Stat;
import com.spring.springbootlearning.service.StatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/stat")
public class StatController {
    private final StatService statService;
    private final Long defaultId = 1l;

    @GetMapping
    public ResponseEntity<Stat> findById(){
        return ResponseEntity.ok(statService.findById(defaultId));
    }
}
