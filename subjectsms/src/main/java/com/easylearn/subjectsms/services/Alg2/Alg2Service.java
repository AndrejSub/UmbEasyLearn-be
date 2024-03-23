package com.easylearn.subjectsms.services.Alg2;

import com.easylearn.subjectsms.collection.subjects.Alg2;
import com.easylearn.subjectsms.dtos.Alg2Dto;
import com.easylearn.subjectsms.repository.Alg2Repository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class Alg2Service extends BaseService<Alg2, Alg2Dto, Alg2Repository> implements IAlg2Service {
    public Alg2Service(Alg2Repository subjectRepository) {
        super(subjectRepository, Alg2Dto.class);
    }
}
