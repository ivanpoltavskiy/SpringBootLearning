package com.spring.springbootlearning.dto.request.priority;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PriorityCreateRequest {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private String color;
}
