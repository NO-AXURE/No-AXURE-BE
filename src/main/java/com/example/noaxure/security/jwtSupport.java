package com.example.noaxure.security;


import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class jwtSupport {
    @Value("${auth.secretKey}")
    private String secretKey;

    @Value("${auth.authExpiry}")
    private long authExpiry;



    public String generateToken(String id,String ip){
        return Jwts.builder()
                .setSubject(id)
                .setSubject(ip)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + authExpiry))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String jwt){
       try {
           Claims claims = Jwts.parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(jwt).getBody();

           return true;
       }catch(ExpiredJwtException e){
           return false;
       }catch(JwtException e){
           return false;
       }
    }

    public String parseJwtFromHeader(HttpServletRequest request){
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(token);
        if(token != null && token.startsWith("Bearer")){
            return token;
        }
        return null;
    }

    public String getUserIdFromJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt).getBody();

        String userId = claims.getSubject().split(";")[0];
        System.out.println(claims.getSubject());
        if(userId==null) return null;
        return userId;
    }

    public String getIpFromJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt).getBody();
        System.out.println(claims.getSubject());
        return null;
    }


}
