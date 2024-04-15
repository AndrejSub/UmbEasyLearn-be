package com.easylearn.identityservice.repository;

import com.easylearn.identityservice.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
    Optional<UserInfo> findByEmail(String email);
}
