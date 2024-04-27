package com.easylearn.identityservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Builder
@Document(collection = "info" )
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private String _id;

    private String userId;

    private String username;

    private String role;

    private String email;

    private String password;

    private Date created_at;

    private Date updated_at;

    private String avatar;
}
