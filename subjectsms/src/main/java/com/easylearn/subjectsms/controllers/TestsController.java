package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.Tests;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.TestsDto;
import com.easylearn.subjectsms.services.TestServices.ITestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/tests")
public class TestsController extends BaseController<Tests, TestsDto, ITestService> {
    ITestService service;
    public TestsController(ITestService service) {
        super(service);
        this.service = service;
    }
    @GetMapping("/ID={id}")
    public List<TestsDto> getBySubjectID(@PathVariable UUID id){
        return service.getTestsBySubjectId(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody TestsDto dto){
        return this.service.create(dto);
    }
}
