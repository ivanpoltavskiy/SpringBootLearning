package com.spring.springbootlearning.dto.response.priority;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PriorityResponse {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private String color;
}
