package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.Subjects;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface SubjectsRepository extends MongoRepository<Subjects, String> {
    Subjects findBySubjectID(String id);
}
