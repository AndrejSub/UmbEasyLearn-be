package com.easylearn.subjectsms.controllers;


import com.easylearn.subjectsms.collection.subjects.Alg2;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.Alg2Dto;
import com.easylearn.subjectsms.services.Alg2.IAlg2Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/alg2")

public class Alg2Controller extends BaseController<Alg2, Alg2Dto, IAlg2Service> {


    public Alg2Controller(IAlg2Service service) {
        super(service);
    }
}

