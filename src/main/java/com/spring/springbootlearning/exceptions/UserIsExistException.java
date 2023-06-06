package com.spring.springbootlearning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class UserIsExistException extends RuntimeException {
    public UserIsExistException (String message){
        super(message);
    }
}
