package com.easylearn.subjectsms.services.TestServices;

import com.easylearn.subjectsms.collection.Tests;
import com.easylearn.subjectsms.dtos.TestsDto;
import com.easylearn.subjectsms.services.base.IBaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ITestService extends IBaseService<Tests, TestsDto> {
    List<TestsDto> getTestsBySubjectId(UUID id);
    ResponseEntity<HttpStatus> create(TestsDto testsDTO);
    List<TestsDto> getTestByTestId(UUID id);
}
