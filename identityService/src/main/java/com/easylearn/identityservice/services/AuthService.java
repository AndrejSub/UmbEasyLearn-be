package com.easylearn.identityservice.services;

import com.easylearn.identityservice.entity.UserInfo;
import com.easylearn.identityservice.repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserInfoRepository userInfoRepository;

    private final PasswordEncoder passwordEncoder;

    private JwtService jwtService;
    public AuthService(
            UserInfoRepository userInfoRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService=  jwtService;
    }


    public String saveUser(UserInfo info){
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        userInfoRepository.save(info);
        return "User Added";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }


}
