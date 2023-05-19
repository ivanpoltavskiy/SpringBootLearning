package com.spring.springbootlearning.repository;

import com.spring.springbootlearning.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    @Query("SELECT  c FROM  Priority c WHERE " +
            "(:title IS NULL OR :title= '' OR lower(c.title) LIKE lower(concat('%', :title, '%') ) )" +
            "ORDER BY c.title ASC ")
    List<Priority> findByTitle(@Param("title") String title);

    List<Priority> findAllByOrderByIdAsc();
}
