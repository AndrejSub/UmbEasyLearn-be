package com.easylearn.subjectsms.services.base;

import java.util.List;

public interface IBaseService<T,DTO>  {

    List<DTO> getAll();
}
