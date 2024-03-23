package com.easylearn.subjectsms.controllers.BaseController;

import com.easylearn.subjectsms.services.base.IBaseService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BaseController<T,DTO, R extends IBaseService<T,DTO> >  {

    protected final R service;

    public BaseController(R service) {
        this.service = service;
    }

    @GetMapping
    public List<DTO> get(){
        return service.getAll();
    }
}
