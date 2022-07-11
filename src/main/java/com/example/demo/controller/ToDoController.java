package com.example.demo.controller;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.ToDoService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ToDoEntity todo, @RequestParam Long id) {
        try {
            toDoService.create(todo, id);
            return ResponseEntity.ok("ToDo successfully registered");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ToDo registration failed");
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.update(id));
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id) {
        try {
            ToDoEntity toDoEntity = toDoService.getToDoEntityById(id);
            if (toDoEntity == null) {
                return ResponseEntity.badRequest().body("ToDoEntity not found");
            }
            UserEntity user = toDoEntity.getUser();
            for (ToDoEntity eachToDoEntity : user.getTodoList()) {
                if (eachToDoEntity.getId().equals(id)) {
                    user.getTodoList().remove(eachToDoEntity);
                    break;
                }
            }
            userService.updateUserEntity(user);
            toDoService.delete(toDoEntity);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Fail");
        }
    }

}
