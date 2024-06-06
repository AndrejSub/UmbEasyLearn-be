package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.Subjects;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.SubjectsDto;

import com.easylearn.subjectsms.services.Subjects.SubjectsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subjects")
public class SubjectsController  {
    private final SubjectsService service;
    public SubjectsController(SubjectsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SubjectsDto>> get(){
        try {
            return this.service.getAll();
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ID={id}")
    public SubjectsDto getBySubjectID(@PathVariable UUID id){
        return service.findBySubjectID(id);
    }


}
