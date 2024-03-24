package com.easylearn.subjectsms.controllers;


import com.easylearn.subjectsms.collection.subjects.Alg1;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.Alg1Dto;
import com.easylearn.subjectsms.services.Alg1.IAlg1Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alg1")
public class Alg1Controller extends BaseController<Alg1, Alg1Dto, IAlg1Service> {

    public Alg1Controller(IAlg1Service service) {
        super(service);
    }


}
