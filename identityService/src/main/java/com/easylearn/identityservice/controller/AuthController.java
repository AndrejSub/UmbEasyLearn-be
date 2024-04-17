package com.easylearn.identityservice.controller;

import com.easylearn.identityservice.entity.Token;
import com.easylearn.identityservice.entity.UserInfo;
import com.easylearn.identityservice.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    private AuthenticationManager  authenticationManager;

    public AuthController(AuthService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo user){
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public Token getToken(@RequestBody UserInfo authRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(),
                    authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            Token token = new Token();
             token.setToken(service.generateToken(authRequest.getEmail()));
             token.setResult(true);
           return token;
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
         service.validateToken(token);
         return "token is valid";
    }



}
