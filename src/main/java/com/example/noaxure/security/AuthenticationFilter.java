package com.example.noaxure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {


    private final jwtSupport jwtSupport;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = jwtSupport.parseJwtFromHeader(request);

            if(token != null && jwtSupport.validateToken(token)){
                System.out.println(request.getRemoteAddr());
                jwtSupport.getIpFromJwt(token);
                response.setStatus(HttpServletResponse.SC_OK);
            }

        }catch(IllegalArgumentException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        filterChain.doFilter(request,response);
    }
}
