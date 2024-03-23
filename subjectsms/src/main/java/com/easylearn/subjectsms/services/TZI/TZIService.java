package com.easylearn.subjectsms.services.TZI;

import com.easylearn.subjectsms.collection.subjects.TZI;
import com.easylearn.subjectsms.dtos.TZIDto;
import com.easylearn.subjectsms.repository.TZIRepository;
import com.easylearn.subjectsms.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TZIService extends BaseService<TZI, TZIDto, TZIRepository> implements ITZIService {
    public TZIService(TZIRepository repository) {
        super(repository, TZIDto.class);
    }
}
