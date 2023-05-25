package com.spring.springbootlearning.dto.request.user;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank(message = "Email cannot be null")
    private String email;
    @NotBlank(message = "Type the password")
    private String password;

}
