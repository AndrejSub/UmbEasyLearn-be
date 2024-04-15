package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.Subjects;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SubjectsRepository extends MongoRepository<Subjects, String> {
    Subjects findBySubjectID(String id);
}
