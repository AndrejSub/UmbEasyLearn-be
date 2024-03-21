package com.easylearn.subjectsms.collection.User;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "info" )
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    private String _id;
    private String email;
    private String password;

}
