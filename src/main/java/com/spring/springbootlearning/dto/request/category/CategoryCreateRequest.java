package com.spring.springbootlearning.dto.request.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequest {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;

}
