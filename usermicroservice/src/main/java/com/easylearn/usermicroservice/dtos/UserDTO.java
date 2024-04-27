package com.easylearn.usermicroservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public String userId;
    public String username;
    public String role;
    public String email;
    public String password;
    public String created_at;
    public String updated_at;
    public String avatar;
}
