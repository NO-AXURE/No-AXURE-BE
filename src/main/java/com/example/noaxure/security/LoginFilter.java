package com.example.noaxure.security;


import com.example.noaxure.model.dto.request.UserRequestDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;


@Slf4j
@RequiredArgsConstructor
@Getter
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    //Manager 구현체를 직접 작성해야한다

    private final jwtSupport jwtSupport;




    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{

            UserRequestDto requestLogin = new ObjectMapper().readValue(request.getInputStream(), UserRequestDto.class);
            Authentication authentication =  new UsernamePasswordAuthenticationToken(requestLogin.getUserId(),requestLogin.getPassword(),new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return authentication;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String userName = authResult.getName();
        SecurityContextHolder.getContext().setAuthentication(authResult);
        response.addHeader("token", jwtSupport.generateToken(userName));
        response.addHeader("userId",userName);
    }


}
