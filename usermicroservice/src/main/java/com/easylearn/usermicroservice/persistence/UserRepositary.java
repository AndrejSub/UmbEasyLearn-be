package com.easylearn.usermicroservice.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositary extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByUserId(String id);
    void deleteUserEntityByUserId(String id);

}
