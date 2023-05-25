package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.request.priority.PriorityCreateRequest;
import com.spring.springbootlearning.dto.response.priority.PriorityResponse;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.mapper.PriorityMapperImpl;
import com.spring.springbootlearning.search.PrioritySearchValues;
import com.spring.springbootlearning.service.PriorityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityService priorityService;
    private PriorityMapperImpl priorityMapper;

    @GetMapping()
    public List<PriorityResponse> priorities() {
        return priorityService.priorities().stream().map(priorityMapper::toDto).toList();
    }

    @PostMapping("/add")
    public ResponseEntity<PriorityResponse> add(@Valid @RequestBody PriorityCreateRequest priorityDto) {
        return new ResponseEntity<>(priorityMapper.toDto(priorityService.add(priorityMapper.fromDto(priorityDto))), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PriorityResponse> update(@Valid @RequestBody PriorityCreateRequest priorityDto) {
        return new ResponseEntity<>(priorityMapper.toDto(priorityService.update(priorityMapper.fromDto(priorityDto))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityResponse> findById(@Valid @PathVariable Long id) {

        return new ResponseEntity<>(priorityMapper.toDto(priorityService.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        priorityService.deleteById(id);
    }

    @PostMapping("/search")
    public List<Priority> search(@RequestBody PrioritySearchValues prioritySearchValues) {
        return priorityService.search(prioritySearchValues);
    }
}
