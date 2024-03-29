package com.spring.springbootlearning.repository;

import com.spring.springbootlearning.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select p from  Task p where "+
            "(:title is null or :title= '' OR lower(p.title) LIKE lower(concat('%', :title, '%') ) ) and"+
            "(:completed is null or p.completed = :completed) and"+
            "(:priorityId is null or p.priority.id = :priorityId) and"+
            "(:categoryId is null or p.category.id = :categoryId)"
    )
    List<Task> findByParams(@Param("title") String title,
                            @Param("completed") Integer completed,
                            @Param("priorityId") Long priorityId,
                            @Param("categoryId") Long categoryId);

}
