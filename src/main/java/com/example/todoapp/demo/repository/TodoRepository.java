package com.example.todoapp.demo.repository;

import com.example.todoapp.demo.entity.TodoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    @Query(value = "SELECT all FROM TodoEntity all")
    List<TodoEntity> fetchAllTo();

    @Query("SELECT singleOne FROM TodoEntity singleOne WHERE singleOne.id = :id")
    Optional<TodoEntity> fetchTodoById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM TodoEntity t WHERE t.id = :id")
    void deleteTodoById(@Param("id") Long id);
}
