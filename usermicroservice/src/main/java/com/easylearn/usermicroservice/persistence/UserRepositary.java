package com.easylearn.usermicroservice.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositary extends MongoRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserId(Long id);
    Optional<UserEntity> findByEmail(String email);
    void deleteUserEntityByUserId(Long id);

}
