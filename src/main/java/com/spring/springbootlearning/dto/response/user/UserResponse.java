package com.spring.springbootlearning.dto.response.user;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
