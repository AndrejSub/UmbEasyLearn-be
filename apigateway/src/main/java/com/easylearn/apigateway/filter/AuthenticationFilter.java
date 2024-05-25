package com.easylearn.apigateway.filter;


import com.easylearn.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.security.SignatureException;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;
    public AuthenticationFilter() {
        super(Config.class);
    }

//    @Autowired
//    private RestTemplate template;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    // Return 401 Unauthorized status code if authorization header is missing
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
                String autheader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (autheader != null && autheader.startsWith("Bearer ")) {
                    autheader = autheader.substring(7);
                }

                if(exchange.getRequest().getMethod() == HttpMethod.DELETE) {
                    String path = String.valueOf(exchange.getRequest().getPath());
                    if (path.contains("/users/email=")) {
                        int index = path.indexOf('=');
                        String email = path.substring(index + 1);
                        try {
                            if (!jwtUtil.extractEmail(autheader).equals(email)) {
                                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                                return exchange.getResponse().setComplete();
                            }
                        } catch (SignatureException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                if(exchange.getRequest().getMethod() == HttpMethod.POST) {
                    String path = String.valueOf(exchange.getRequest().getPath());
                    if (path.contains("api/tests") || path.contains("/api/subjects")) {
                        try {
                            String role = jwtUtil.extractRole(autheader);
                            if(!role.equals("admin")) {
                                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                                return exchange.getResponse().setComplete();
                            }
                        } catch (SignatureException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                try {
                    // template.getForObject("http://localhost:6666/auth/validate?token"+autheader,String.class);
                    jwtUtil.validateToken(autheader);
                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    // Return 403 Forbidden status code for unauthorized access
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }

            return chain.filter(exchange);
        }));
    }


    public static class Config{

    }
}
