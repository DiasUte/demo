package com.example.demo.service;


import com.example.demo.entity.UserEntity;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity register(UserEntity user) {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            return null;
        } else {
            return userRepo.save(user);
        }
    }

    public UserModel getUser(Long id) {
        if(userRepo.findById(id) == null) {
            return null;
        } else {
            return UserModel.toModel(userRepo.findById(id).get());
        }
    }

    public UserEntity updateUserEntity(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }





}
