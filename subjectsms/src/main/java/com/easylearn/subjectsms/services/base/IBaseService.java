package com.easylearn.subjectsms.services.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

public interface IBaseService<T,DTO>  {

    ResponseEntity<List<DTO>> getAll();
    ResponseEntity<DTO> getById(String id);
    ResponseEntity<HttpStatus> DeleteById(String id);
    ResponseEntity<HttpStatus> create(@RequestBody DTO dto);
//    ResponseEntity<DTO> UpdateSubject(String id,DTO book);


}
