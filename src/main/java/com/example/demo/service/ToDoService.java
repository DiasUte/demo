package com.example.demo.service;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.ToDoModel;
import com.example.demo.repository.ToDoRepo;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;
    @Autowired
    private UserRepo userRepo;

    public ToDoEntity create(ToDoEntity todo, Long id) {
        UserEntity user = userRepo.findById(id).get();
        if(user != null) {
            todo.setUser(user);
            return toDoRepo.save(todo);
        } else {
            return null;
        }
    }

    public void delete(ToDoEntity toDoEntity) {
        toDoRepo.delete(toDoEntity);
    }

    public ToDoEntity getToDoEntityById(Long id) {
        return toDoRepo.findById(id).orElse(null);
    }

    public ToDoModel update(Long id) {
        ToDoEntity todo = toDoRepo.findById(id).get();
        todo.setComplete(!todo.isComplete());
        return ToDoModel.toModel(toDoRepo.save(todo));
    }

}
