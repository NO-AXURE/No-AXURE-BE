package com.example.noaxure.auth;


import com.example.noaxure.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthSupport {

    @Value("${auth.secretKey}")
    private static String SECRET_KEY;

    @Value("${auth.authExpiry}")
    private static long   AUTH_EXPIRY;

    @Value("${auth.refreshExpiry}")
    private long   REFRESH_EXPIRY;



    public static String generateToken(String id){
        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + AUTH_EXPIRY))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

//    public boolean validateToken(){
//
//    }


}
