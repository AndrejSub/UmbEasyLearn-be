package com.easylearn.usermicroservice.controllers;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{email}")
    public UserDTO getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
    @DeleteMapping("/email={email}")
    public void deleteUserbyEmail(@PathVariable String email){
        userService.deleteUserbyEmail(email);
    }

    @PostMapping("/update")
    public Long changePhoto(@RequestBody UserEntity userEntity){
        return this.userService.upadateUserByPost(userEntity);
    }
}
