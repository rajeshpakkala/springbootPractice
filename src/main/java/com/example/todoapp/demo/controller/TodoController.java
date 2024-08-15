package com.example.todoapp.demo.controller;

import com.example.todoapp.demo.entity.TodoEntity;
import com.example.todoapp.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    public List<TodoEntity> fetchAll(){
        return todoService.fetchingAll();
    }

    @GetMapping("/{id}")
    public TodoEntity getbyid(@PathVariable long id){
        return todoService.getbyid(id);
    }
   @PostMapping("/create")
    public TodoEntity createTodo(@RequestBody TodoEntity todo){
        return todoService.createTodo(todo);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoEntity> update(@PathVariable Long id,@RequestBody TodoEntity todo){
        TodoEntity todoEntity=todoService.updateTodo(id,todo);
        return ResponseEntity.ok(todoEntity);
    }

    @DeleteMapping("/{id}")
    public TodoEntity delete(@PathVariable long id){
        return todoService.deleting(id);

    }
}
