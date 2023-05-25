package com.spring.springbootlearning.entity;


import lombok.*;

import javax.persistence.*;

@Builder
@Table(name= "user")
@Entity
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "password")
    private String password;

//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
//    private Set<Task> tasks;
}
