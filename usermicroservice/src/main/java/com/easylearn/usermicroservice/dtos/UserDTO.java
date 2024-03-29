package com.easylearn.usermicroservice.dtos;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public Long user_id;
    public String username;
    public String email;
    public String password;
    public Date created_at;
    public Date updated_at;
}
