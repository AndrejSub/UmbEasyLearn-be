package com.easylearn.usermicroservice.mappers;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.persistence.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO mapUserEntityToDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity mapUserDTOtoEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
