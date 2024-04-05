package com.easylearn.usermicroservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public Long userId;
    public String username;
    public String role;
    public String email;
    public String password;
    public Date created_at;
    public Date updated_at;
}
