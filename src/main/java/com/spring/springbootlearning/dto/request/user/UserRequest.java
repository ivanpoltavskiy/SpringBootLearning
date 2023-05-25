package com.spring.springbootlearning.dto.request.user;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
