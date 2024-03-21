package com.easylearn.subjectsms.controllers;


import com.easylearn.subjectsms.collection.subjects.Alg2;
import com.easylearn.subjectsms.services.IAlg2Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/alg2")

public class Alg2Controller {
    private final IAlg2Service alg2Service;

    public Alg2Controller(IAlg2Service alg2Service) {
        this.alg2Service = alg2Service;
    }

//    @PostMapping
//    public String save(@RequestBody Alg2 alg2){
//        return predmetService.save(alg2);
//    }


    @GetMapping
    public List<Alg2> getPredmet(){
        return alg2Service.getAll();
    }

}
