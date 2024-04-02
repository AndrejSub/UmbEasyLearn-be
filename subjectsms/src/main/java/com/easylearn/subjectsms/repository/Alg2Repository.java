package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.subjects.Alg2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alg2Repository extends MongoRepository<Alg2,String> {
}