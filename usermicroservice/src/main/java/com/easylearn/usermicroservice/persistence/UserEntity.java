package com.easylearn.usermicroservice.persistence;


import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "info")
public class UserEntity implements UserDetails {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private Long userId;
    @Field
    private String username;
    @Field
    private String role;
    @Field
    private String email;
    @Field
    private String password;
    @Field
    private Date created_at;
    @Field
    private Date updated_at;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        GrantedAuthority - list of roles
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
