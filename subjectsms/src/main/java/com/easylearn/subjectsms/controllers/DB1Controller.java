package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.subjects.DB1;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.DB1Dto;
import com.easylearn.subjectsms.services.DB1.IDB1Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/db1")
public class DB1Controller extends BaseController<DB1, DB1Dto, IDB1Service> {
    public DB1Controller(IDB1Service service) {
        super(service);
    }
}
