package com.easylearn.usermicroservice.controllers;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public UserEntity createUser(@RequestBody UserDTO userDTO){
        System.out.println("New user was created. Username: " + userDTO.getUsername());
        return userService.createUser(userDTO);
    }

    @GetMapping("/get/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }
    @GetMapping("/all")
    public List<UserDTO> getAllCustomers(){
        return userService.getAllCustomers();
    }
}
