package com.easylearn.identityservice.services;

import com.easylearn.identityservice.entity.UserInfo;
import com.easylearn.identityservice.repository.UserInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

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


    public ResponseEntity saveUser(UserInfo info){
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        UserInfo user =userInfoRepository.findByEmail(info.getEmail()).orElse(null);
        if(user == null) {
            info.setUserId(UUID.randomUUID().toString());
            userInfoRepository.save(info);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity changePassword(UserInfo info){
        try {
            UserInfo user = this.getUserInfoByEmail(info.getEmail());
            if(user.getEmail() == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            user.setPassword(passwordEncoder.encode(info.getPassword()));
            userInfoRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    public UserInfo getUserInfoByEmail(String email){
        return userInfoRepository.findByEmail(email).orElse(null);
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }


}
