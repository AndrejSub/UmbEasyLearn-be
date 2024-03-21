package com.easylearn.subjectsms.controllers;


import com.easylearn.subjectsms.collection.subjects.Alg1;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.services.Alg1Service;
import com.easylearn.subjectsms.services.IAlg1Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alg1")
public class Alg1Controller extends BaseController<Alg1, Alg1Service> {

    public Alg1Controller(Alg1Service service) {
        super(service);
    }


}
