package com.easylearn.subjectsms.services.base;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public abstract class BaseService<T, R extends MongoRepository<T, String>> implements IBaseService<T> {

    protected final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

}
