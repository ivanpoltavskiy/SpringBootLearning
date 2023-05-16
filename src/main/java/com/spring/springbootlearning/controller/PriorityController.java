package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.request.priority.PriorityCreateRequest;
import com.spring.springbootlearning.dto.response.priority.PriorityResponse;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.mapper.PriorityMapperImpl;
import com.spring.springbootlearning.search.PrioritySearchValues;
import com.spring.springbootlearning.service.PriorityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/priority")
public class PriorityController {

    private PriorityService priorityService;
    private PriorityMapperImpl priorityMapper;

    @GetMapping()
    public List<PriorityResponse> priorities(){
        return priorityService.priorities().stream().map(priorityMapper::toDto).toList();
    }

    @PostMapping("/add")
    public PriorityResponse add (@RequestBody PriorityCreateRequest priorityDto){
        return priorityMapper.toDto(priorityService.add(priorityMapper.fromDto(priorityDto)));
    }

    @PutMapping("/update")
    public PriorityResponse update (@RequestBody PriorityCreateRequest priorityDto){
        return priorityMapper.toDto(priorityService.update(priorityMapper.fromDto(priorityDto)));
    }

    @GetMapping("id/{id}")
    public PriorityResponse findById(@PathVariable Long id){

        return priorityMapper.toDto(priorityService.findById(id));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        priorityService.deleteById(id);
    }
    @PostMapping("/search")
    public List<Priority> search(@RequestBody PrioritySearchValues prioritySearchValues){
        return priorityService.search(prioritySearchValues);

    }
}
