package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.subjects.TZI;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.TZIDto;
import com.easylearn.subjectsms.services.TZI.ITZIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tzi")
public class TZIController extends BaseController<TZI, TZIDto, ITZIService> {
    public TZIController(ITZIService service) {
        super(service);
    }
}
