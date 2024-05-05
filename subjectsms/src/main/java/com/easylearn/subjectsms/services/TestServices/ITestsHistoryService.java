package com.easylearn.subjectsms.services.TestServices;

import com.easylearn.subjectsms.collection.TestsHistory;
import com.easylearn.subjectsms.dtos.TestsHistoryDto;
import com.easylearn.subjectsms.services.base.IBaseService;

import java.util.List;

public interface ITestsHistoryService extends IBaseService<TestsHistory, TestsHistoryDto> {
    List<TestsHistoryDto> getTestByEmail(String email);
}
