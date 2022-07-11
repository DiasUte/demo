package com.example.demo.model;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.entity.UserEntity;

import java.util.stream.Collectors;

public class ToDoModel {
    private Long id;
    private String title;
    private boolean complete;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static ToDoModel toModel(ToDoEntity todo) {
        ToDoModel model = new ToDoModel();
        model.setId(todo.getId());
        model.setTitle(todo.getTitle());
        model.setComplete(todo.isComplete());
        model.setDescription(todo.getDescription());
        return model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
