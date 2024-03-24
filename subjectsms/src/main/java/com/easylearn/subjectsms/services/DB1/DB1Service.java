package com.easylearn.subjectsms.services.DB1;

import com.easylearn.subjectsms.collection.subjects.DB1;
import com.easylearn.subjectsms.dtos.DB1Dto;
import com.easylearn.subjectsms.repository.DB1Repository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class DB1Service extends BaseService<DB1, DB1Dto, DB1Repository> implements IDB1Service {
    public DB1Service(DB1Repository repository) {
        super(repository, DB1Dto.class,DB1.class);
    }
}
