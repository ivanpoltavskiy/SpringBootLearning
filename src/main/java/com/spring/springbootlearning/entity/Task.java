package com.spring.springbootlearning.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data


public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private Integer completed;
    private Date date;
    @ManyToOne
    private Priority priority;
    @ManyToOne
    private Category category;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;


}
