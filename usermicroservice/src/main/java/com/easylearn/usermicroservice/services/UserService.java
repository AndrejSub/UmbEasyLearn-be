package com.easylearn.usermicroservice.services;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.mappers.UserDTOMapper;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.persistence.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepositary userRepositary;
    @Autowired
    UserDTOMapper userDTOMapper;
    @Autowired
    MongoTemplate mongoTemplate;
    public UserService(UserRepositary userRepositary){
        this.userRepositary = userRepositary;
    }
    public UserEntity createUser(UserDTO userDTO){
        Date date = new Date();
        UserEntity user = userDTOMapper.mapUserDTOtoEntity(userDTO);
        user.setCreated_at(date);
        user.setUpdated_at(date);
        user.setRole("user");
        return userRepositary.save(user);
    }
    public UserDTO getUser(String id){
        Optional<UserEntity> optionalUserEntity = userRepositary.findByUserId(id);
        if (optionalUserEntity.isEmpty()){
            return null;
        }
        UserEntity user = optionalUserEntity.get();
        return userDTOMapper.mapUserEntityToDTO(user);
    }
    public UserDTO getUserByEmail(String email){
        Optional<UserEntity> optionalUserEntity = userRepositary.findByEmail(email);
        if (optionalUserEntity.isEmpty()){
            return null;
        }
        UserEntity user = optionalUserEntity.get();
        return userDTOMapper.mapUserEntityToDTO(user);
    }
    public List<UserDTO> getAllUsers(){
        Iterable<UserEntity> userEntities = userRepositary.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity userEntity: userEntities){
            userDTOS.add(userDTOMapper.mapUserEntityToDTO(userEntity));
        }
        if(userDTOS.isEmpty()){
            return null;
        }
        return userDTOS;
    }
    public void updateUserPhoto(String email, UserDTO userDTO){
        Date date = new Date();
        Optional<UserEntity> optionalUserEntity = userRepositary.findByEmail(email);
        if(optionalUserEntity.isEmpty()){
            System.out.println("NULL");
        }
        UserEntity user = optionalUserEntity.get();
        user.setAvatar(userDTO.getAvatar());
//        user.setUpdated_at(date);
        userRepositary.save(user);
    }
    public UserEntity updateUser(String id, UserDTO userDTO){
        Date date = new Date();
        Optional<UserEntity> optionalUserEntity = userRepositary.findByUserId(id);
        if (optionalUserEntity.isEmpty()){
            System.out.println("NULL");
            return null;
        }
        UserEntity user = optionalUserEntity.get();
        userRepositary.deleteUserEntityByUserId(id);
        user.setUsername(userDTO.getUsername() == null ? "NOT_FOUND" : userDTO.getUsername());
        user.setEmail(userDTO.getEmail() == null ? "NOT_FOUND" : userDTO.getEmail());
        user.setRole("user");
        user.setUpdated_at(date);
        return userRepositary.save(user);
    }
    public void deleteUser(String id){
        userRepositary.deleteUserEntityByUserId(id);
    }
}
