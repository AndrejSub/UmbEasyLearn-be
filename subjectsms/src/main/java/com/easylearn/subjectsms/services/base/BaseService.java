package com.easylearn.subjectsms.services.base;

import com.easylearn.subjectsms.collection.Base.BaseSubject;
import com.easylearn.subjectsms.dtos.Base.BaseSubjectDto;
import com.easylearn.subjectsms.helpers.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public  class BaseService<T extends BaseSubject, DTO extends BaseSubjectDto, R extends MongoRepository<T, String>> implements IBaseService<T,DTO> {

    protected final R repository;

    @Autowired
    private BaseMapper<T,DTO> mapper;

    private final Class<DTO> dtoClass;

    private final Class<T> entityClass;

    public BaseService(R repository, Class<DTO> dtoClass,Class<T> entityClass) {
        this.repository = repository;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;

    }

    public ResponseEntity<List<DTO>> getAll() {
        try {
            return new ResponseEntity<>(mapper.mapListEntityToListDto(repository.findAll(),dtoClass),HttpStatus.OK);
        } catch (Exception exception){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<DTO> getById(String id) {
        try {
            T test = repository.findById(id).orElse(null);
            if(test != null) {
                return new ResponseEntity<>(mapper.mapEntityToDto(repository.findById(id).orElse(null), dtoClass), HttpStatus.OK);
            }
            throw  new RuntimeException("Not found");
            } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        }

    @Override
    public ResponseEntity<HttpStatus> create(DTO subjectDTO) {
        try {
            repository.save(mapper.mapDtoToEntity(subjectDTO, entityClass));
            return  new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception exception) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> DeleteById(String id) {
        try{
            this.repository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<DTO> UpdateSubject(String id, DTO subjectDTO) {
        T subject = this.repository.findById(id).orElse(null);

        if (subject != null){
            subject.setSubject_id(subjectDTO.getSubject_id());
            subject.setSubject_name(subjectDTO.getSubject_name());
            subject.setFlash_cards(subjectDTO.getFlash_cards());
            subject.setText_questions(subjectDTO.getText_questions());
            subject.setPrakticka_uloha(subjectDTO.getPrakticka_uloha());
            this.repository.save(subject);
            return new ResponseEntity<>(mapper.mapEntityToDto(subject,dtoClass),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


