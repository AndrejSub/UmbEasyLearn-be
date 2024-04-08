package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.Subjects;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.SubjectsDto;

import com.easylearn.subjectsms.services.Subjects.SubjectsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin
public class SubjectsController extends BaseController<Subjects, SubjectsDto, SubjectsService> {
    private final SubjectsService service;
    public SubjectsController(SubjectsService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/ID={id}")
    public SubjectsDto getBySubjectID(@PathVariable UUID id){
        return service.findBySubjectID(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody SubjectsDto dto){
        return this.service.create(dto);
    }
}
