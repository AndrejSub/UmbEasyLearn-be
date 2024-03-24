package com.easylearn.subjectsms.services.base;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IBaseService<T,DTO>  {

    ResponseEntity<List<DTO>> getAll();
    ResponseEntity<DTO> getById(String id);
    ResponseEntity<HttpStatus> create(DTO subjectDTO);
    ResponseEntity<HttpStatus> DeleteById(String id);
    ResponseEntity<DTO> UpdateSubject(String id,DTO book);


}
