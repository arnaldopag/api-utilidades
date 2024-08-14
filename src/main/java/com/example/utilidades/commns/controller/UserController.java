package com.example.utilidades.commns.controller;

import com.example.utilidades.commns.user.User;
import com.example.utilidades.commns.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
