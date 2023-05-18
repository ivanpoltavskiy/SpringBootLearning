package com.spring.springbootlearning.dto.response.priority;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriorityResponse {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private String color;
}
