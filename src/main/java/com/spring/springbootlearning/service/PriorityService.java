package com.spring.springbootlearning.service;

import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.exceptions.PriorityNotFoundException;
import com.spring.springbootlearning.repository.PriorityRepository;
import com.spring.springbootlearning.search.PrioritySearchValues;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PriorityService {
    private PriorityRepository priorityRepository;


    public List<Priority> priorities() {
        return priorityRepository.findAllByOrderByIdAsc();
    }


    public Priority add(Priority priority) {
        return priorityRepository.save(priority);
    }


    public Priority update(Priority priority) {
        return priorityRepository.save(priority);
    }


    public Priority findById(Long id) {
        return priorityRepository.findById(id).orElseThrow(() -> new PriorityNotFoundException("Priority with id " + id + " not found"));
    }

    public void deleteById(Long id) {
        try {
            priorityRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Priority> search(PrioritySearchValues prioritySearchValues) {
        return priorityRepository.findByTitle(prioritySearchValues.getText());
    }
}
