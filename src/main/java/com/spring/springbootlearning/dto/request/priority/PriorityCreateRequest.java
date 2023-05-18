package com.spring.springbootlearning.dto.request.priority;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriorityCreateRequest {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private String color;
}
