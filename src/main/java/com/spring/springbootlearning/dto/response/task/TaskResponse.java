package com.spring.springbootlearning.dto.response.task;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import com.spring.springbootlearning.entity.User;
import lombok.Data;

import java.sql.Date;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private Integer completed;
    private Date date;
    private Priority priority;
    private Category category;
    private User user;
}
