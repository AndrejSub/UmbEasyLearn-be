package com.easylearn.usermicroservice.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositary extends MongoRepository<UserEntity, Long> {
}
