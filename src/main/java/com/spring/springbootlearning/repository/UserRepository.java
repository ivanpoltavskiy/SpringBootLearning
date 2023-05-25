package com.spring.springbootlearning.repository;

import com.spring.springbootlearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByIdAsc();

    Optional<User> findUserByEmail(String email);

    Boolean existsUserByEmail(String email);
}
