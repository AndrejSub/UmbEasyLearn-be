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
//    @PostMapping()
//    public UserEntity createUser(@RequestBody UserDTO userDTO){
//        return userService.createUser(userDTO);
//    }
    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
//    @PutMapping("/{id}")
//    public UserEntity updateUser(@PathVariable String id, @RequestBody UserDTO userDTO){
//        return userService.updateUser(id, userDTO);
//    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
    @DeleteMapping("/email={email}")
    public void deleteUserbyEmail(@PathVariable String email){
        userService.deleteUserbyEmail(email);
    }
//    @PatchMapping("/{email}")
//    public void updateUserPhoto(@PathVariable String email, @RequestBody UserDTO userDTO){
//        System.out.println("zmenil som");
//        userService.updateUserPhoto(email, userDTO);
//    }
    @PostMapping("/update")
    public Long changePhoto(@RequestBody UserEntity userEntity){
        return this.userService.upadateUserByPost(userEntity);
    }
}
