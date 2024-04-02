package com.easylearn.subjectsms.services.Subjects;

import com.easylearn.subjectsms.collection.Subjects;
import com.easylearn.subjectsms.collection.Tests;
import com.easylearn.subjectsms.dtos.SubjectsDto;
import com.easylearn.subjectsms.dtos.TestsDto;
import com.easylearn.subjectsms.helpers.BaseMapper;
import com.easylearn.subjectsms.repository.SubjectsRepository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;
import java.util.UUID;

@Service
public class SubjectsService extends BaseService<Subjects, SubjectsDto, SubjectsRepository> implements ISubjectsService {
    private final SubjectsRepository repository;

    @Autowired
    private BaseMapper<Subjects,SubjectsDto> mapper;

    public SubjectsService(SubjectsRepository repository) {
        super(repository, SubjectsDto.class, Subjects.class);
        this.repository = repository;
    }

    public SubjectsDto findBySubjectID(UUID id){
        return mapper.mapEntityToDto(repository.findBySubjectID(id.toString()),SubjectsDto.class);
    }

    @Override
    public ResponseEntity<HttpStatus> create(SubjectsDto subjectsDTO) {
        try {
            Subjects entity =  mapper.mapDtoToEntity(subjectsDTO, Subjects.class);
            entity.setSubjectID(UUID.randomUUID().toString());
            repository.save(entity);
            return  new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception exception) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
