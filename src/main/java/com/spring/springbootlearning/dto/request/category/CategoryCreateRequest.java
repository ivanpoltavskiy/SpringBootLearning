package com.spring.springbootlearning.dto.request.category;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryCreateRequest {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private Long completedCount;
    private Long uncompletedCount;

}
