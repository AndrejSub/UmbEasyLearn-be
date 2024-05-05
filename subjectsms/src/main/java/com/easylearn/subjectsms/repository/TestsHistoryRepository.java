package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.TestsHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsHistoryRepository extends MongoRepository<TestsHistory, String> {
    List<TestsHistory> findTestsHistoriesByEmail(String email);
}
