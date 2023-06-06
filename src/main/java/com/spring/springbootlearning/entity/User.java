package com.spring.springbootlearning.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Task> tasks;
}
