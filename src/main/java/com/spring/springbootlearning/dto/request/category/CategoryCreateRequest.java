package com.spring.springbootlearning.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequest {
    private Long id;
    @NotBlank(message = "Title cannot be null")
    private String title;
    private Long completedCount;
    private Long uncompletedCount;

}
