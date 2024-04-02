package com.easylearn.usermicroservice.events;

import com.easylearn.usermicroservice.dtos.UserDTO;
import com.easylearn.usermicroservice.persistence.UserEntity;
import com.easylearn.usermicroservice.services.SequenceGeneratorService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserEntityListener extends AbstractMongoEventListener<UserDTO> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<UserDTO> event){
        if (event.getSource().getUser_id() < 1) {
            event.getSource().setUser_id(SequenceGeneratorService.generateSequence(UserEntity.SEQUENCE_NAME));
        }
    }
}
