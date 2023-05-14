package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.entity.Task;
import com.spring.springbootlearning.repository.TaskRepository;
import com.spring.springbootlearning.search.TaskSearchValues;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private TaskRepository taskRepository;

    @GetMapping()
    public ResponseEntity<List<Task>> tasks() {
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        if (task.getId() != null && task.getId() != 0) {
            return new ResponseEntity("ID should be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            return new ResponseEntity("Title cannot be null", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task) {
        if (task.getId() == null && task.getId() == 0) {
            return new ResponseEntity("ID should not be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            return new ResponseEntity("Title cannot be null", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = null;
        try {
            task = taskRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found!", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found!", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<List<Task>> search(@RequestBody TaskSearchValues taskSearchValues){

        String title = taskSearchValues.getTitle() != null ? taskSearchValues.getTitle() : null;
        Integer completed = taskSearchValues.getCompleted() != null ? taskSearchValues.getCompleted() : null;
        Long priorityID = taskSearchValues.getPriorityId() !=null ? taskSearchValues.getPriorityId() : null;
        Long categoryId = taskSearchValues.getCategoryId() !=null ? taskSearchValues.getCategoryId() : null;

        return ResponseEntity.ok(taskRepository.findByParams(title, completed, priorityID, categoryId));

    }
}
