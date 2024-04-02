package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.Tests;
import com.easylearn.subjectsms.dtos.TestsDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsRepository  extends MongoRepository<Tests, String> {
    List<Tests> findBySubjectID(String id);
}
