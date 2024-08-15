package com.example.todoapp.demo.service;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.example.todoapp.demo.entity.TodoEntity;
import com.example.todoapp.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> fetchingAll(){
        return todoRepository.fetchAllTo();
    }

    public TodoEntity getbyid(Long id){
       Optional<TodoEntity>todoEntity=todoRepository.fetchTodoById(id);
       if(todoEntity.isPresent()){
           return todoEntity.get();
       }
       throw new RuntimeException("id is not in db");
    }

    public TodoEntity createTodo(TodoEntity todo){
        return todoRepository.save(todo);
    }

    public TodoEntity updateTodo(Long id,TodoEntity todo){
        TodoEntity todoEntity=todoRepository.fetchTodoById(id).orElseThrow(()-> new RuntimeException("id is not found man"));
        return todoRepository.save(todo);
    }

    public TodoEntity deleting(Long id){
        Optional<TodoEntity> todoentity=todoRepository.findById(id);
        if(todoentity.isPresent()){
            todoRepository.deleteTodoById(id);
            return todoentity.get();
        }
        throw new RuntimeException("id"+id+" is not found");
    }
}
