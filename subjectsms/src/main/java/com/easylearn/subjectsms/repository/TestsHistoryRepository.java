package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.TestsHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsHistoryRepository extends MongoRepository<TestsHistory, String> {
}
