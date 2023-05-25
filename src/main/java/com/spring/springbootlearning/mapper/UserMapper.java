package com.spring.springbootlearning.mapper;

import com.spring.springbootlearning.dto.request.user.LoginRequest;
import com.spring.springbootlearning.dto.request.user.RegisterRequest;
import com.spring.springbootlearning.dto.response.user.UserResponse;
import com.spring.springbootlearning.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toDto(User entity);
    User fromDto(LoginRequest dto);
    User fromDto(RegisterRequest dto);
}
