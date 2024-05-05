package com.easylearn.subjectsms.controllers;

import com.easylearn.subjectsms.collection.TestsHistory;
import com.easylearn.subjectsms.controllers.BaseController.BaseController;
import com.easylearn.subjectsms.dtos.TestsHistoryDto;
import com.easylearn.subjectsms.services.TestServices.ITestsHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/testhistory")
public class TestsHistoryController extends BaseController<TestsHistory, TestsHistoryDto, ITestsHistoryService> {
    public TestsHistoryController(ITestsHistoryService service) {
        super(service);
    }

    @GetMapping("/email={email}")
    public List<TestsHistoryDto> getByEmail(@PathVariable String email) {
        return this.service.getTestByEmail(email);
    }
}
