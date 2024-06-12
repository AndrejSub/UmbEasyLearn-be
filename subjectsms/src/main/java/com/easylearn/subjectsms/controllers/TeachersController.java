package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.dtos.TeacherDto;
import com.easylearn.subjectsms.services.teacher.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/teachers")
public class TeachersController {
    private final TeacherService service;

    public TeachersController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable UUID id) {
        return service.findByTeacherId(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createTeacher(@RequestBody TeacherDto teacherDto) {
        return service.create(teacherDto);
    }
}
