package com.spring.springbootlearning.service;

import com.spring.springbootlearning.entity.Task;
import com.spring.springbootlearning.exceptions.UserNotFoundException;
import com.spring.springbootlearning.repository.TaskRepository;
import com.spring.springbootlearning.search.TaskSearchValues;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserService userService;

    public List<Task> tasks() {
        return taskRepository.findAll();
    }

    public Task add(Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        task.setUser(userService.findByEmail(authentication.getName()));
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

        public Task findById(Long id) {
            return taskRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Task with id " + id + " not found"));
        }

    public void deleteById(Long id) {
        try {
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();

        }
    }

    public List<Task> search(TaskSearchValues taskSearchValues) {

        String title = taskSearchValues.getTitle() != null ? taskSearchValues.getTitle() : null;
        Integer completed = taskSearchValues.getCompleted() != null ? taskSearchValues.getCompleted() : null;
        Long priorityID = taskSearchValues.getPriorityId() != null ? taskSearchValues.getPriorityId() : null;
        Long categoryId = taskSearchValues.getCategoryId() != null ? taskSearchValues.getCategoryId() : null;

        return taskRepository.findByParams(title, completed, priorityID, categoryId);
    }

}

