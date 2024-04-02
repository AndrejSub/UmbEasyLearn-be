package com.easylearn.subjectsms.services.Subjects;

import com.easylearn.subjectsms.collection.Subjects;
import com.easylearn.subjectsms.dtos.SubjectsDto;
import com.easylearn.subjectsms.services.base.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ISubjectsService extends IBaseService<Subjects, SubjectsDto> {
    SubjectsDto findBySubjectID(UUID id);
    ResponseEntity<HttpStatus> create(SubjectsDto subjectsDto);
}
