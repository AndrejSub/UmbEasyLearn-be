package com.easylearn.subjectsms.controllers.BaseController;

import com.easylearn.subjectsms.services.base.BaseService;
import com.easylearn.subjectsms.services.base.IBaseService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BaseController<T, R extends IBaseService<T> >  {

    protected final R service;

    public BaseController(R service) {
        this.service = service;
    }

    @GetMapping
    public List<T> get(){
        return service.getAll();
    }
}
