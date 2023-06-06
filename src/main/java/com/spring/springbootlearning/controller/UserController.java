package com.spring.springbootlearning.controller;

import com.spring.springbootlearning.dto.response.user.UserResponse;
import com.spring.springbootlearning.mapper.UserMapperImpl;
import com.spring.springbootlearning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserMapperImpl userMapper;

    @GetMapping
    public List<UserResponse> users(){
        return userService.users().stream().map(userMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return userMapper.toDto(userService.findUserById(id));
    }
    @GetMapping("/test")
    public String getAuthUser(Authentication authentication){
        return userService.getAuthUser(authentication);
    }
}
