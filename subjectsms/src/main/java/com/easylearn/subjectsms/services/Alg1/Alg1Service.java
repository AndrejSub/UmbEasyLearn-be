package com.easylearn.subjectsms.services.Alg1;

import com.easylearn.subjectsms.collection.subjects.Alg1;
import com.easylearn.subjectsms.dtos.Alg1Dto;
import com.easylearn.subjectsms.repository.Alg1Repository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class Alg1Service extends BaseService<Alg1, Alg1Dto, Alg1Repository> implements IAlg1Service{

    public Alg1Service(Alg1Repository repository) {
        super(repository,Alg1Dto.class, Alg1.class);
    }


}
