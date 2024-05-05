package com.easylearn.subjectsms.services.TestServices;

import com.easylearn.subjectsms.collection.TestsHistory;
import com.easylearn.subjectsms.dtos.TestsHistoryDto;
import com.easylearn.subjectsms.helpers.BaseMapper;
import com.easylearn.subjectsms.repository.TestsHistoryRepository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TestsHistoryService extends BaseService<TestsHistory, TestsHistoryDto, TestsHistoryRepository> implements ITestsHistoryService{
    public TestsHistoryService(TestsHistoryRepository repository) {
        super(repository, TestsHistoryDto.class, TestsHistory.class);
    }

    @Autowired
    private BaseMapper<TestsHistory, TestsHistoryDto> mapper;

    @Override
    public List<TestsHistoryDto> getTestByEmail(String email) {
         return mapper.mapListEntityToListDto(this.repository.findTestsHistoriesByEmail(email),TestsHistoryDto.class);
    }
}
