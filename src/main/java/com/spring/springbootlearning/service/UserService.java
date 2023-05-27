package com.spring.springbootlearning.service;

import com.spring.springbootlearning.entity.User;
import com.spring.springbootlearning.exceptions.UserNotFoundException;
import com.spring.springbootlearning.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public List<User> users(){
        return userRepository.findAllByOrderByIdAsc();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("Not found"));
    }
    public User findByEmail(String email){
        return userRepository.findUserByEmail(email).get();
    }

    public Boolean existUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }
}
