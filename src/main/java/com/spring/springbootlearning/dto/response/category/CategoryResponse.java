package com.spring.springbootlearning.dto.response.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
}
