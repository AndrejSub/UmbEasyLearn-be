package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.subjects.Matika;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.MatikaDto;
import com.easylearn.subjectsms.services.Matika.IMatikaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matika")
public class MatikaController extends BaseController<Matika, MatikaDto, IMatikaService> {
    public MatikaController(IMatikaService service) {
        super(service);
    }
}
