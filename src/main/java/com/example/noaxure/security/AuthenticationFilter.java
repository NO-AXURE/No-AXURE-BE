package com.example.noaxure.security;

import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.table.User;
import com.example.noaxure.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {


    private final jwtSupport jwtSupport;
    private final UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = jwtSupport.parseJwtFromHeader(request);

            if(token != null && jwtSupport.validateToken(token)){
                String userId = jwtSupport.getUserIdFromJwt(token);
                User user = userService.get(userId);
                Authentication authentication =  new UsernamePasswordAuthenticationToken(user.getUserId(),user.getPassword(),new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                response.setStatus(HttpServletResponse.SC_OK);
            }

        }catch(IllegalArgumentException e){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        filterChain.doFilter(request,response);
    }
}
