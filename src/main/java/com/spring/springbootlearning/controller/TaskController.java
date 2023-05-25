package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.request.task.TaskCreateRequest;
import com.spring.springbootlearning.dto.response.task.TaskResponse;
import com.spring.springbootlearning.entity.Task;
import com.spring.springbootlearning.mapper.TaskMapperImpl;
import com.spring.springbootlearning.search.TaskSearchValues;
import com.spring.springbootlearning.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    private TaskMapperImpl taskMapper;

    @GetMapping()
    public List<TaskResponse> tasks() {
        return taskService.tasks().stream().map(taskMapper::toDto).toList();
    }

    @PostMapping("/add")
    public ResponseEntity<TaskResponse> add(@Valid @RequestBody TaskCreateRequest taskDto) {
        return new ResponseEntity<>(taskMapper.toDto(taskService.add(taskMapper.fromDto(taskDto))), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<TaskResponse> update(@Valid @RequestBody TaskCreateRequest taskDto) {
        return new ResponseEntity<>(taskMapper.toDto(taskService.update(taskMapper.fromDto(taskDto))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(@Valid @PathVariable Long id) {
        return new ResponseEntity<>(taskMapper.toDto(taskService.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @PostMapping("/search")
    public List<Task> search(@RequestBody TaskSearchValues taskSearchValues) {
        return taskService.search(taskSearchValues);

    }
}
