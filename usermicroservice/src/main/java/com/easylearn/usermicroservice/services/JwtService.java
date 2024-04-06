package com.easylearn.usermicroservice.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECURE_KEY="EF44359EFCD588C6C523119118D44";

    public String extractUser(String jwtToken) {
        return extractAnyClaim(jwtToken, Claims::getId);
    }
    private Claims extractAllClaim(String jwtToken){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }
// generic
    public <T> T extractAnyClaim(String jwtToken, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaim(jwtToken);
        return claimsResolver.apply(claims);
    }
//    generate token without extraClaims
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
//                then will help to check ether token is valid or not
                .setIssuedAt(new Date(System.currentTimeMillis()))
//                token will be valid for 24 hours
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

//    method for validation token
    public boolean isTokenValid(String jwtToken, UserDetails userDetails){
        final String username = extractUser(jwtToken);
        return (username.equals(userDetails.getUsername())) && !isToKenExired(jwtToken);
    }

    private boolean isToKenExired(String jwtToken) {
        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {
        return extractAnyClaim(jwtToken, Claims::getExpiration);
    }

    private Key getSignKey() {
//        decoding key
        byte[] keyBytes = Decoders.BASE64.decode(SECURE_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
