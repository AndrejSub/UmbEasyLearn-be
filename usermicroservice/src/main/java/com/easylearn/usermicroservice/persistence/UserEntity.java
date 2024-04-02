package com.easylearn.usermicroservice.persistence;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "info")
public class UserEntity {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Long user_id;

    private String username;
    private String email;
    private String password;
    private Date created_at;
    private Date updated_at;

}
