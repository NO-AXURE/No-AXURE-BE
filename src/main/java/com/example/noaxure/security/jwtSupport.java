package com.example.noaxure.security;


import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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



    public String generateToken(String id){
        return Jwts.builder()
                .setSubject(id)
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
        if(token != null && token.startsWith("Bearer")){
            return token.substring(7);
        }
        return null;
    }

    public String getUserIdFromJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt).getBody();
        String userId = claims.getSubject().split(";")[0];
        System.out.println(userId);
        System.out.println(claims.getSubject()+"SS");
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
