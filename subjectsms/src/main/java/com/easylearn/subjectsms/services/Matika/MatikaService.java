package com.easylearn.subjectsms.services.Matika;

import com.easylearn.subjectsms.collection.subjects.Matika;
import com.easylearn.subjectsms.dtos.MatikaDto;
import com.easylearn.subjectsms.repository.MatikaRepository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class MatikaService extends BaseService<Matika, MatikaDto, MatikaRepository> implements IMatikaService {
    public MatikaService(MatikaRepository repository) {
        super(repository, MatikaDto.class,Matika.class);
    }
}
