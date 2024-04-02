package com.easylearn.subjectsms.services.TestServices;



import com.easylearn.subjectsms.collection.Tests;
import com.easylearn.subjectsms.dtos.TestsDto;
import com.easylearn.subjectsms.helpers.BaseMapper;
import com.easylearn.subjectsms.repository.TestsRepository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TestsService extends BaseService<Tests, TestsDto, TestsRepository> implements ITestService {
    TestsRepository repository;

    @Autowired
    private BaseMapper<Tests, TestsDto> mapper;
    public TestsService(TestsRepository repository ) {
        super(repository, TestsDto.class, Tests.class);
        this.repository = repository;
    }

    public List<TestsDto> getTestsBySubjectId(UUID id){
        return mapper.mapListEntityToListDto(this.repository.findBySubjectID(id.toString()), TestsDto.class);
    }

    @Override
    public ResponseEntity<HttpStatus> create(TestsDto testsDtoDTO) {
        try {
            Tests entity =  mapper.mapDtoToEntity(testsDtoDTO, Tests.class);
            entity.setTestID(UUID.randomUUID().toString());
            repository.save(entity);
            return  new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception exception) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
