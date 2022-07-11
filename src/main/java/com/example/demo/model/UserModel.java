package com.example.demo.model;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String username;
    private List<ToDoModel> todoList;

    public static UserModel toModel(UserEntity user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setUsername(user.getUsername());
        model.setTodoList(user.getTodoList().stream().map(ToDoModel::toModel).collect(Collectors.toList()));
        return model;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ToDoModel> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<ToDoModel> todoList) {
        this.todoList = todoList;
    }
}
