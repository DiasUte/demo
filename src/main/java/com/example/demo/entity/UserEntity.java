package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
    private List<ToDoEntity> todoList;

    public UserEntity() {
    }

    public UserEntity(String username, String password, List<ToDoEntity> todoList) {
        this.username = username;
        this.password = password;
        this.todoList = todoList;
    }

    public List<ToDoEntity> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<ToDoEntity> todoList) {
        this.todoList = todoList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
