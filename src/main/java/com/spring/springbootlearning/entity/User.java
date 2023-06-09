package com.spring.springbootlearning.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String password;
    @OneToMany
    @JsonIgnore
    private Set<Task> tasks;
}
