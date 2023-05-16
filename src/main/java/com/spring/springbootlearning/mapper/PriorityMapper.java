package com.spring.springbootlearning.mapper;

import com.spring.springbootlearning.dto.request.priority.PriorityCreateRequest;
import com.spring.springbootlearning.dto.response.priority.PriorityResponse;
import com.spring.springbootlearning.entity.Priority;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriorityMapper {
    PriorityResponse toDto(Priority entity);

    Priority fromDto(PriorityCreateRequest dto);
}
