package com.spring.springbootlearning.dto.request.task;

import com.spring.springbootlearning.entity.Category;
import com.spring.springbootlearning.entity.Priority;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class TaskCreateRequest {
    private Long id;

    @NotBlank(message = "Title cannot be null")
    private String title;
    @NotNull(message ="Type 0 or 1" )
    @Min(value = 0, message = "You can choose only 0 or 1")
    @Max(value = 1, message = "You can choose only 0 or 1")
    private Integer completed;
    @Future(message = "You can choose only future time")
    private Date date;
    @NotNull(message ="Priority cannot be null" )
    private Priority priority;
    @NotNull(message ="Category cannot be null" )
    private Category category;
}
