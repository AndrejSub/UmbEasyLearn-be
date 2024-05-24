package com.easylearn.identityservice.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    OWNER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
