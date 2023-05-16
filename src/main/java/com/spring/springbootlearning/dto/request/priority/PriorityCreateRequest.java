package com.spring.springbootlearning.dto.request.priority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriorityCreateRequest {
    private Long id;
    private String title;
    private String color;
}
