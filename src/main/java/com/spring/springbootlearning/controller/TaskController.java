package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.request.task.TaskCreateRequest;
import com.spring.springbootlearning.dto.response.task.TaskResponse;
import com.spring.springbootlearning.entity.Task;
import com.spring.springbootlearning.mapper.TaskMapperImpl;
import com.spring.springbootlearning.search.TaskSearchValues;
import com.spring.springbootlearning.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public TaskResponse add(@RequestBody TaskCreateRequest taskDto) {
        return taskMapper.toDto(taskService.add(taskMapper.fromDto(taskDto)));
    }

    @PutMapping("/update")
    public TaskResponse update(@RequestBody TaskCreateRequest taskDto) {
        return taskMapper.toDto(taskService.update(taskMapper.fromDto(taskDto)));
    }

    @GetMapping("id/{id}")
    public TaskResponse findById(@PathVariable Long id) {
        return taskMapper.toDto(taskService.findById(id));
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
