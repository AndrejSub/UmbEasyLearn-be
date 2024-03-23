package com.easylearn.subjectsms.services.base;

import com.easylearn.subjectsms.helpers.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract class BaseService<T, DTO, R extends MongoRepository<T, String>> implements IBaseService<T,DTO> {

    protected final R repository;

    @Autowired
    private BaseMapper<T,DTO> mapper;

    private final Class<DTO> dtoClass;

    public BaseService(R repository, Class<DTO> dtoClass) {
        this.repository = repository;
        this.dtoClass = dtoClass;

    }

    public List<DTO> getAll() {
        return  mapper.mapListEntityToListDto(repository.findAll(),dtoClass);
    }

}
