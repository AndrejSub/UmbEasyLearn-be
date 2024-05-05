package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.TestsHistory;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.TestsHistoryDto;
import com.easylearn.subjectsms.services.TestServices.ITestsHistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testhistory")
public class TestsHistoryController extends BaseController<TestsHistory, TestsHistoryDto, ITestsHistoryService> {
    public TestsHistoryController(ITestsHistoryService service) {
        super(service);
    }
}
