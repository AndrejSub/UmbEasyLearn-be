package com.easylearn.identityservice.config;

import com.easylearn.identityservice.entity.UserInfo;
import com.easylearn.identityservice.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> credential = repository.findByEmail(username);
        return credential.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found with name: "+username));
    }
}
