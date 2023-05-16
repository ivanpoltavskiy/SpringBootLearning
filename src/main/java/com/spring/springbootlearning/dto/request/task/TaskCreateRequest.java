package com.spring.springbootlearning.dto.request.task;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class TaskCreateRequest {
    private Long id;
    private String title;
    private Integer completed;
    private Date date;
    private Priority priority;
    private Category category;
}
