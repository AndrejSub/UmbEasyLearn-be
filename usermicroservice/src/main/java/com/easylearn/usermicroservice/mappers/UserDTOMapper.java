package com.easylearn.usermicroservice.mappers;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.services.SequenceGeneratorService;
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
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setUser_id(SequenceGeneratorService.generateSequence(UserEntity.SEQUENCE_NAME));
        return userEntity;
    }
}
