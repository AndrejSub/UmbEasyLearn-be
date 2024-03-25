package com.easylearn.usermicroservice.services;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.mappers.UserDTOMapper;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.persistence.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepositary userRepositary;
    @Autowired
    UserDTOMapper userDTOMapper;
    public UserService(UserRepositary userRepositary){
        this.userRepositary = userRepositary;
    }
    public UserEntity createUser(UserDTO userDTO){
        return userRepositary.save(userDTOMapper.mapUserDTOtoEntity(userDTO));
    }
    //    TODO:???
    public UserDTO getUser(Long id){
        Optional<UserEntity> optionalUserEntity = userRepositary.findById(id);
        System.out.println(optionalUserEntity);
        if(optionalUserEntity.isEmpty()){
            System.out.println("???");
            return null;
        }
        UserEntity userEntity = optionalUserEntity.get();
        return userDTOMapper.mapUserEntityToDTO(userEntity);
    }
    public List<UserDTO> getAllCustomers(){
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
//    TODO: update, delete when findById fixed
}
