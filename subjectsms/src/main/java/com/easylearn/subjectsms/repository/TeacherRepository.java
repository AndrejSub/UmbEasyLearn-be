package com.easylearn.subjectsms.repository;

import com.easylearn.subjectsms.collection.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

    Teacher findByTeacherId(String id);
}
