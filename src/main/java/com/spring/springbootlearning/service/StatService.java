package com.spring.springbootlearning.service;

import com.spring.springbootlearning.entity.Stat;
import com.spring.springbootlearning.repository.StatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class StatService {
    StatRepository statRepository;

    public Stat findById(Long id) {
        return statRepository.findById(id).get();
    }
}
