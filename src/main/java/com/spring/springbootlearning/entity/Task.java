package com.spring.springbootlearning.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode

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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="user_id", nullable = false)
    private User user;


}
