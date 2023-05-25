package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.request.user.LoginRequest;
import com.spring.springbootlearning.dto.request.user.RegisterRequest;
import com.spring.springbootlearning.dto.response.user.UserResponse;
import com.spring.springbootlearning.mapper.UserMapperImpl;
import com.spring.springbootlearning.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserMapperImpl userMapper;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register (@Valid @RequestBody RegisterRequest register){
        return new ResponseEntity<>(userMapper.toDto(authService.register(userMapper.fromDto(register))), HttpStatus.OK);

    }
    @PostMapping("/login")
    public ResponseEntity<Void> login (@Valid @RequestBody LoginRequest login){
        authService.login(userMapper.fromDto(login));
        return ResponseEntity.ok().build();
    }
}
