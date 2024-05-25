package com.easylearn.identityservice.services;

import com.easylearn.identityservice.entity.UserInfo;
import com.easylearn.identityservice.repository.UserInfoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SignatureException;
import java.util.Objects;
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
            info.setRole("user");
            info.setAvatar("data:image/jpeg;base64,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\n");
            userInfoRepository.save(info);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity changePassword(UserInfo info,String authHeader) throws SignatureException {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader = authHeader.substring(7);

            if (Objects.equals(info.getEmail(), jwtService.extractEmail(authHeader))) {
                try {

                    UserInfo user = this.getUserInfoByEmail(info.getEmail());
                    if (user.getEmail() == null) {
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    }
                    user.setPassword(passwordEncoder.encode(info.getPassword()));
                    userInfoRepository.save(user);
                    return new ResponseEntity<>(HttpStatus.OK);
                } catch (Exception exception) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    public String getRoleByEmail(String email){
        UserInfo user =  userInfoRepository.findByEmail(email).orElse(null);
        if(user != null){
            return user.getRole();
        }
        else return "user";
    }

    public UserInfo getUserInfoByEmail(String email){
        return userInfoRepository.findByEmail(email).orElse(null);
    }

    public String generateToken(String username, String role){
        return jwtService.generateToken(username,role);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }


    public String getEmail(String token) throws SignatureException {
        return jwtService.extractEmail(token);
    }


}
