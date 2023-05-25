package com.spring.springbootlearning.dto.request.user;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {
    @Email
    private String email;
    @Size(min = 2, max = 16, message = "Type name between 2 and 16")
    private String name;
    @Size(min = 2, max = 16, message = "Type last name between 2 and 16")
    private String lastName;

    private String password; // TODO: 22-May-23 type validation for password
    private String confirmPassword;

}
