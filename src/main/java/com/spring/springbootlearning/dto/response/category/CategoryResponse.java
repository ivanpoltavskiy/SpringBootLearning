package com.spring.springbootlearning.dto.response.category;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryResponse {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
}
