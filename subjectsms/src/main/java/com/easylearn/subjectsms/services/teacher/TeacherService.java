package com.easylearn.subjectsms.services.teacher;

import com.easylearn.subjectsms.collection.Teacher;
import com.easylearn.subjectsms.dtos.TeacherDto;
import com.easylearn.subjectsms.helpers.BaseMapper;
import com.easylearn.subjectsms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.UUID;


@Service
public class TeacherService {
    private final TeacherRepository repository;
    private final BaseMapper<Teacher, TeacherDto> mapper;

    @Autowired
    public TeacherService(TeacherRepository repository, BaseMapper<Teacher, TeacherDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public ResponseEntity<HttpStatus> create(TeacherDto teacherDTO) {
        try {
            Teacher entity = mapper.mapDtoToEntity(teacherDTO, Teacher.class);
            repository.save(entity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public TeacherDto findByTeacherId(UUID id) {
        Teacher teacher = repository.findByTeacherId(id.toString());
        if (teacher != null) {
            return mapper.mapEntityToDto(teacher, TeacherDto.class);
        } else {
            return null;
        }
    }

}
