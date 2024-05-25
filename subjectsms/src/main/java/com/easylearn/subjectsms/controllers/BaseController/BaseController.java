package com.easylearn.subjectsms.controllers.BaseController;

import com.easylearn.subjectsms.services.base.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T,DTO, R extends IBaseService<T,DTO> >  {

    protected final R service;

    public BaseController(R service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DTO>> get(){
        try {
            return this.service.getAll();
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable String id){
        return this.service.getById(id);

    }
    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody DTO dto){
        return this.service.create(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id){
        return this.service.DeleteById(id);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<DTO> update(@PathVariable String id,@RequestBody DTO dto){
//        return this.service.UpdateSubject(id,dto);
//
//    }

}
