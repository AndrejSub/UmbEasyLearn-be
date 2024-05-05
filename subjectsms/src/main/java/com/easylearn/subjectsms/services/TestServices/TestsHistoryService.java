package com.easylearn.subjectsms.services.TestServices;

import com.easylearn.subjectsms.collection.TestsHistory;
import com.easylearn.subjectsms.dtos.TestsHistoryDto;
import com.easylearn.subjectsms.repository.TestsHistoryRepository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.stereotype.Service;


@Service
public class TestsHistoryService extends BaseService<TestsHistory, TestsHistoryDto, TestsHistoryRepository> implements ITestsHistoryService{
    public TestsHistoryService(TestsHistoryRepository repository) {
        super(repository, TestsHistoryDto.class, TestsHistory.class);
    }
}
