package com.spring.springbootlearning.mapper;

import com.spring.springbootlearning.dto.request.task.TaskCreateRequest;
import com.spring.springbootlearning.dto.response.task.TaskResponse;
import com.spring.springbootlearning.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponse  toDto(Task entity);

    Task fromDto(TaskCreateRequest dto);
}
